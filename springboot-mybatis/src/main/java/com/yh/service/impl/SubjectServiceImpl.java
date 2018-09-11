package com.yh.service.impl;

import com.yh.entity.wrap.TeacherSubject;
import com.yh.mapper.SubjectMapper;
import com.yh.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<TeacherSubject> selectBytchId(Long tchId, Byte role) {
        return subjectMapper.selectBytchId(tchId,role);
    }
}
