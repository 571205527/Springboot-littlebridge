package com.yh.service;

import com.yh.entity.Class;
import com.yh.entity.wrap.GradeClassStudents;

import java.util.List;

/**
 * Created by HR on 2018/5/16.
 */
public interface ClassService {

    List<GradeClassStudents> getClassStudents(Long schId);

    List<Class> getAllClass();
}
