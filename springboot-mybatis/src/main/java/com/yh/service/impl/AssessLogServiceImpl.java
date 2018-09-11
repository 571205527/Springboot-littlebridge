package com.yh.service.impl;

import com.yh.entity.AssessLog;
import com.yh.entity.wrap.*;
import com.yh.mapper.AssessLogMapper;
import com.yh.service.AssessLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HR on 2018/5/17.
 */
@Service
public class AssessLogServiceImpl implements AssessLogService {

    @Autowired
    private AssessLogMapper assessLogMapper;


    @Override
    public List<ItemPowerStatistics> getAssessLogStatistics(Integer module, Long schId, Long tchId, Long stuOrClassId, Integer start, Integer end, Integer classYear, Byte role, Long cid) {
        List<ItemPowerStatistics> itemStatistics = assessLogMapper.getStudentClassGradeStatistics(module, schId, tchId, stuOrClassId, start, end, classYear, role, cid);
        return itemStatistics;
    }

    @Override
    public List<ItemTimeStatistics> geAssessLogTimeStatistics(Integer module, Long schId, Long tchId, Long stuOrClassId, Integer start, Integer end, Integer classYear, Integer unit, Byte role, Long cid) {

        List<ItemTimeStatistics> itemTimeStatisticsList = assessLogMapper.getStudentClassGradeStatisticsByTime(module, schId, tchId, stuOrClassId, start, end, classYear, unit, role, cid);
        return itemTimeStatisticsList;
    }

    @Override
    public List<StudentStatistics> getStudentStatistics(Integer module, Long classId, Integer start, Integer end, Integer classYear, Long order) {
        return assessLogMapper.getStudentStatistics(module, classId,start,end,classYear,order);
    }

    @Override
    public List<StudentStatistics> getClassStatistics(Integer start, Integer end, Integer classYear, Long order) {
        return assessLogMapper.getClassStatistics(start,end,classYear,order);
    }

    @Override
    public List<AssessFlow> getEventLogByAssessId(Integer module, Long tchId, Integer classId, Integer stuId, String date) {
        return assessLogMapper.getEventLogByAssessId(module, tchId,classId, stuId,date);
    }

    @Override
    public List<AssessFlow> getAssessLogBytchId(Integer module, Long tchId, Integer classId, Integer stuId, String date, Byte role, Long cid) {
        return assessLogMapper.getAssessLogBytchId(module, tchId,classId, stuId,date,role,cid);
    }

    /*@Override
    public List<AssessFlow> getAssessLogBytchId(Long tchId, Integer page) {
        return assessLogMapper.getAssessLogBytchId(tchId, page);
    }*/

    @Override
    public int updateByPrimaryKeySelective(AssessLog record) {
        return assessLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public ItemPowerStatistics getAssessStatistics(Long stuId, Integer classYear, Integer start, Integer end) {
        return assessLogMapper.getAssessStatistics(stuId, classYear, start, end);
    }

}
