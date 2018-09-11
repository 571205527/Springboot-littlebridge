package com.yh.service;

import com.yh.entity.SignSubject;
import com.yh.entity.wrap.SignStatistics;
import com.yh.entity.wrap.SignStudentList;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public interface SignSubjectService {

    int insertDistinct(SignSubject record);

    int updateByPrimaryKeySelective(SignSubject record);

    int getCountSign(Long subId, Long tchId);
    //int updateBySubAndDate(Integer subId, Integer tchId, Integer stuId, String date, Byte role);

    List<SignStudentList> getSignStudent(Long subId, Long tchId, String date, Byte role);

    List<SignStatistics> getSignStatistics(Integer module, Long classId, Long stuId, String start, String end, Byte role, Long cid);

    List<SignStatistics> getSubStatistics(/*Integer module, */Long tchId, Long subId, String start, String end, Byte role);
}
