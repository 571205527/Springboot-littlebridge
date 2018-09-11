package com.yh.service.impl;

import com.yh.entity.Class;
import com.yh.entity.wrap.GradeClassStudents;
import com.yh.mapper.ClassMapper;
import com.yh.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HR on 2018/5/16.
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<GradeClassStudents> getClassStudents(Long schId) {
        return classMapper.getClassStudents(schId);
    }

    @Override
    public List<Class> getAllClass() {
        return classMapper.getAllClass();
    }
}
