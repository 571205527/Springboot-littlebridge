package com.yh.service;

import com.yh.entity.EventLog;
import com.yh.entity.wrap.EventAssessment;
import com.yh.entity.wrap.TimeLine;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.List;

/**
 * Created by HR on 2018/5/17.
 */
public interface EventLogService {

    int insertEventLog(EventLog eventLog);

    int insertEventAssessment(EventAssessment eventAssessment) throws ParseException;

    int updateByPrimaryKeySelective(EventLog record);

    List<EventLog> selectByDate(@Param("date") String date);

    List<TimeLine> getTimeLine(String date, Long classId, Long stuId, Long tchId, Byte role, Long cid);

    List<TimeLine> getCommon(String date, Long classId, Long stuId);

    List<TimeLine> getCardLog(String date, Long classId, Long stuId);

    List<TimeLine> selectByTag(Long tchId, Long eventCategory, String start, String end, Byte role, Long cid);

    List<TimeLine> selectOtherClass(Long tchId, Long eventCategory, String start, String end, Byte role, Long cid);
}
