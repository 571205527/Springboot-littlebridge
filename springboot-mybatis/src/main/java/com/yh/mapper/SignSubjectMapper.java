package com.yh.mapper;

import com.yh.entity.SignSubject;
import com.yh.entity.wrap.SignStatistics;
import com.yh.entity.wrap.SignStudentList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignSubjectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SignSubject record);

    int insertSelective(SignSubject record);

    SignSubject selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SignSubject record);

    int updateByPrimaryKey(SignSubject record);

    int getCountSign(@Param("subId") Long subId, @Param("tchId") Long tchId);

    int insertDistinct(SignSubject record);

    //int updateBySubAndDate(@Param("subId") Integer subId, @Param("tchId") Integer tchId, @Param("stuId") Integer stuId, @Param("date") String date, @Param("role") Byte role);

    List<SignStudentList> getSignStudent(@Param("subId") Long subId, @Param("tchId") Long tchId, @Param("date") String date, @Param("role") Byte role);

    List<SignStatistics> getSignStatistics(@Param("module") Integer module, @Param("classId") Long classId, @Param("stuId") Long stuId, @Param("start") String start, @Param("end") String end, @Param("role") Byte role, @Param("cid") Long cid);

    List<SignStatistics> getSubStatistics(/*@Param("module") Integer module, */@Param("tchId") Long tchId, @Param("subId") Long subId, @Param("start") String start, @Param("end") String end, @Param("role") Byte role);
}