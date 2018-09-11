package com.yh.service;

import com.yh.entity.AssessLog;
import com.yh.entity.wrap.*;

import java.util.List;

/**
 * Created by HR on 2018/5/17.
 */
public interface AssessLogService {

    //能量站报表
    List<ItemPowerStatistics> getAssessLogStatistics(Integer module, Long schId, Long tchId, Long stuOrClassId, Integer start, Integer end, Integer classYear, Byte role, Long cid);
    List<ItemTimeStatistics> geAssessLogTimeStatistics(Integer module, Long schId, Long tchId, Long stuOrClassId, Integer start, Integer end, Integer classYear, Integer unit, Byte role, Long cid);

    //排行榜
    List<StudentStatistics> getStudentStatistics(Integer module, Long classId, Integer start, Integer end, Integer classYear, Long order);
    List<StudentStatistics> getClassStatistics( Integer start, Integer end, Integer classYear, Long order);

    //流水账
    List<AssessFlow> getEventLogByAssessId(Integer module, Long tchId, Integer classId, Integer stuId, String date);
    List<AssessFlow> getAssessLogBytchId(Integer module, Long tchId, Integer classId, Integer stuId, String date, Byte role, Long cid);
    //List<AssessFlow> getAssessLogBytchId(Long tchId, Integer page);

    int updateByPrimaryKeySelective(AssessLog record);

    ItemPowerStatistics getAssessStatistics(Long stuId, Integer classYear, Integer start, Integer end);

    //ItemPowerStatistics getAwardAssess(Integer classYear, Long stuId, Integer start, Integer end);
}
