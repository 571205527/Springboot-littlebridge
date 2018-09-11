package com.yh.service.impl;

import com.yh.entity.SignSubject;
import com.yh.entity.wrap.SignStatistics;
import com.yh.entity.wrap.SignStudentList;
import com.yh.mapper.SignSubjectMapper;
import com.yh.service.SignSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
@Service
public class SignSubjectServiceImpl implements SignSubjectService {

    @Autowired
    private SignSubjectMapper ssm;

    @Override
    public int insertDistinct(SignSubject record) {
        return ssm.insertDistinct(record);
    }

    @Override
    public int updateByPrimaryKeySelective(SignSubject record) {
        return ssm.updateByPrimaryKeySelective(record);
    }

    /*@Override
    public int updateBySubAndDate(Integer subId, Integer tchId, Integer stuId, String date, Byte role) {
        return ssm.updateBySubAndDate(subId, tchId, stuId, date, role);
    }*/

    @Override
    public List<SignStudentList> getSignStudent(Long subId, Long tchId, String date, Byte role) {
        return ssm.getSignStudent(subId, tchId, date, role);
    }

    @Override
    public List<SignStatistics> getSignStatistics(Integer module, Long classId, Long stuId, String start, String end, Byte role, Long cid) {
        return ssm.getSignStatistics(module, classId, stuId, start, end, role, cid);
    }

    @Override
    public List<SignStatistics> getSubStatistics(/*Integer module, */Long tchId, Long subId, String start, String end, Byte role) {
        return ssm.getSubStatistics(tchId, subId, start, end, role);
    }

    @Override
    public int getCountSign(Long subId, Long tchId){
        return ssm.getCountSign(subId,tchId);
    }
}
