package com.yh.service.impl;

import com.yh.entity.Teacher;
import com.yh.mapper.TeacherMapper;
import com.yh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by HR on 2018/5/16.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByUsername(String username) {
        return teacherMapper.getTeacherByUsername(username);
    }
}
