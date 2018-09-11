package com.yh.service.impl;

import com.yh.entity.AssessLog;
import com.yh.entity.EventLog;
import com.yh.entity.wrap.EventAssessment;
import com.yh.entity.wrap.TimeLine;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.mapper.AssessLogMapper;
import com.yh.mapper.EventLogMapper;
import com.yh.service.EventLogService;
import com.yh.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.*;

import java.util.List;

/**
 * Created by HR on 2018/5/17.
 */
@Service
public class EventLogServiceImpl implements EventLogService {

    @Autowired
    private EventLogMapper eventLogMapper;

    @Autowired
    private AssessLogMapper assessLogMapper;

    @Override
    public List<TimeLine> getTimeLine(String date, Long classId, Long stuId, Long tchId, Byte role, Long cid) {
        return eventLogMapper.getTimeLine(date,classId,stuId,tchId, role, cid);
    }

    @Override
    public List<TimeLine> getCommon(String date, Long classId, Long stuId) {
        return eventLogMapper.getCommon(date,classId,stuId);
    }

    @Override
    public List<TimeLine> getCardLog(String date, Long classId, Long stuId) {
        return eventLogMapper.getCardLog(date,classId,stuId);
    }

    @Override
    public List<TimeLine> selectByTag(Long tchId, Long eventCategory, String start, String end, Byte role, Long cid) {
        return eventLogMapper.selectByTag(tchId,eventCategory,start,end,role,cid);
    }

    @Override
    public List<TimeLine> selectOtherClass(Long tchId, Long eventCategory, String start, String end, Byte role, Long cid) {
        return eventLogMapper.selectOtherClass(tchId, eventCategory, start, end, role, cid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Throwable.class)
    public int insertEventLog(EventLog eventLog) {

        try {
            EventLog eventLogSelect = eventLogMapper.selectByPrimaryKey(10l);

            eventLogSelect.setStuId(1255l);
            System.out.println(eventLogSelect + "-------------->>><<<");
            eventLogMapper.updateByPrimaryKey(eventLogSelect);
            int a = 1 / 0;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 1;
    }
       // return eventLogMapper.insertSelective(eventLog);
    //}

    @Override
    @Transactional
    public int insertEventAssessment(EventAssessment eventAssessment) throws ParseException {
        LinkedList<Long> assessLogIds = null;
        if (eventAssessment.getItemId() != null && !eventAssessment.getItemId().equals(0)) {

            assessLogIds = new LinkedList<>();
            for (int i=0;i<eventAssessment.getStuIds().size();i++) {
                Long stuId = eventAssessment.getStuIds().get(i);
                Long classId = eventAssessment.getClassId().get(i);
                AssessLog assessLog = packAssessLog(
                        eventAssessment.getSchId(),
                        //eventAssessment.getClassId(),
                        eventAssessment.getTchId(),
                        eventAssessment.getItemId(),
                        eventAssessment.getTagId(),
                        eventAssessment.getAssessSrc(),
                        eventAssessment.getAssessType(),
                        eventAssessment.getAssessNum(),
                        eventAssessment.getAssessScore(),
                        eventAssessment.getAssessTime()
                );

                assessLog.setStuId(stuId);
                assessLog.setClassId(classId);
                try {
                    assessLogMapper.insertSelective(assessLog);
                    assessLogIds.add(assessLog.getId());
                } catch (Exception e) {
                    throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "插入评价log失败" + e.getMessage());
                }
            }
        }

        if (eventAssessment.getEventNote() != null && !"".equals(eventAssessment.getEventNote())) {

            List<EventLog> eventLogs = new ArrayList<>();
            System.out.println("事件记录----------------------  "+eventAssessment.getStuIds().size());
            for (int i = 0; i < eventAssessment.getStuIds().size(); i++) {
                EventLog eventLog = packEventLog(
                        eventAssessment.getSchId(),
                        //eventAssessment.getClassIds(),
                        eventAssessment.getTchId(),
                        eventAssessment.getEventCategory(),
                        eventAssessment.getEventLocation(),
                        eventAssessment.getEventNote(),
                        eventAssessment.getEventTime()
                );
                eventLog.setStuId(eventAssessment.getStuIds().get(i));
                eventLog.setClassId(eventAssessment.getClassId().get(i));

                if(assessLogIds != null && assessLogIds.size() > 0){
                    eventLog.setAssessId(assessLogIds.get(i));
                }else{
                    eventLog.setAssessId((long) 0);
                }
                eventLogs.add(eventLog);
            }

            int result = eventLogMapper.insertBatch(eventLogs);

            if (result != eventAssessment.getStuIds().size()) {
                throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "插入事件log失败");
            }
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(EventLog record) {
        return eventLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<EventLog> selectByDate(String date) {
        return eventLogMapper.selectByDate(date);
    }

    private AssessLog packAssessLog(Long schId, /*Long classId,*/ Long tchId, Long itemId, List<String> tagIds, Byte assessSrc, Byte assessType, Byte assessNum, Byte assessScore, String assessTime) throws ParseException {
        AssessLog assessLog = new AssessLog();

        assessLog.setSchId(schId);
        //assessLog.setClassId(classId);
        assessLog.setTchId(tchId);
        assessLog.setItemId(itemId);
        assessLog.setAssessSrc(assessSrc);
        assessLog.setAssessType(assessType);
        assessLog.setAssessNum(assessNum);
        assessLog.setAssessScore(assessScore);
        assessLog.setAssessTime(BaseUtil.stringToDate(assessTime));

        StringBuilder tagIdChain = new StringBuilder();
        for (String tagId : tagIds) {
            tagIdChain.append(tagId).append(",");
        }
        assessLog.setTagId(tagIdChain.toString());
        assessLog.setStatus((byte) 0);
        assessLog.setDateDay(BaseUtil.YEAR_MONTH_DAY().get("year") * 10000 + BaseUtil.YEAR_MONTH_DAY().get("month") * 100 + BaseUtil.YEAR_MONTH_DAY().get("day"));
        assessLog.setDateMonth(BaseUtil.YEAR_MONTH_DAY().get("year") * 100 + BaseUtil.YEAR_MONTH_DAY().get("month"));
        assessLog.setDateWeek(BaseUtil.YEAR_WEEK());
        assessLog.setCreatedDt(new Date());
        assessLog.setUpdatedDt(new Date());

        return assessLog;
    }

    private EventLog packEventLog(Long schId, /*Long classId,*/ Long tchId, Long tagId, String eventLocation, String eventNote, String eventTime) throws ParseException {
        EventLog eventLog = new EventLog();

        eventLog.setSchId(schId);
        //eventLog.setClassId(classId);
        eventLog.setTchId(tchId);
        eventLog.setEventCategory(tagId);
        eventLog.setEventLocation(eventLocation);
        eventLog.setEventNote(eventNote);
        eventLog.setEventTime(BaseUtil.stringToDate(eventTime));
        eventLog.setStatus((byte) 0);
        eventLog.setDateDay(BaseUtil.YEAR_MONTH_DAY().get("year") * 10000 + BaseUtil.YEAR_MONTH_DAY().get("month") * 100 + BaseUtil.YEAR_MONTH_DAY().get("day"));
        eventLog.setCreatedDt(new Date());
        eventLog.setUpdatedDt(new Date());

        return eventLog;
    }

}
