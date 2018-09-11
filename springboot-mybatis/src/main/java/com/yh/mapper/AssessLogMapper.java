package com.yh.mapper;

import com.yh.entity.AssessLog;
import com.yh.entity.wrap.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AssessLog record);

    Long insertSelective(AssessLog record);

    AssessLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssessLog record);

    int updateByPrimaryKey(AssessLog record);

    int insertBatch(List<AssessLog> assessLogs);

    int insertBatchSelective(List<AssessLog> assessLogs);

    //排行
    List<StudentStatistics> getStudentStatistics(@Param("module") Integer module, @Param("classId") Long classId, @Param("start") Integer start, @Param("end") Integer end, @Param("classYear") Integer classYear, @Param("order") Long order);

    List<StudentStatistics> getClassStatistics(@Param("start") Integer start, @Param("end") Integer end, @Param("classYear") Integer classYear, @Param("order") Long order);

    //能量站报表
    List<ItemPowerStatistics> getStudentClassGradeStatistics(@Param("module") Integer module, @Param("sschId") Long schId, @Param("tchId") Long tchId, @Param("stuOrClassId")  Long stuOrClassId, @Param("start") Integer start, @Param("end") Integer end, @Param("classYear") Integer classYear, @Param("role") Byte role, @Param("cid") Long cid);

    List<ItemTimeStatistics> getStudentClassGradeStatisticsByTime(@Param("module") Integer module, @Param("schId") Long schId, @Param("tchId") Long tchId, @Param("stuOrClassId") Long stuOrClassId, @Param("start") Integer start, @Param("end") Integer end, @Param("classYear") Integer classYear, @Param("unit") Integer unit, @Param("role") Byte role, @Param("cid") Long cid);

    //评价流水
    //List<AssessFlow> getAssessLogBytchId(@Param("tchId") Long tchId,@Param("page") Integer page);
    List<AssessFlow> getEventLogByAssessId(@Param("module") Integer module, @Param("tchId") Long tchId, @Param("classId") Integer classId, @Param("stuId") Integer stuId, @Param("date") String date);
    List<AssessFlow> getAssessLogBytchId(@Param("module") Integer module, @Param("tchId") Long tchId, @Param("classId") Integer classId, @Param("stuId") Integer stuId, @Param("date") String date, @Param("role") Byte role, @Param("cid") Long cid);

    //成长报告
    ItemPowerStatistics getAssessStatistics(@Param("stuId") Long stuId, @Param("classYear") Integer classYear, @Param("start") Integer start, @Param("end") Integer end);
    //ItemPowerStatistics getAwardAssess(Integer classYear, Long stuId, Integer start, Integer end);
}