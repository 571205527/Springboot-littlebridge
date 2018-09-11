package com.yh.service;

import com.yh.entity.wrap.TeacherSubject;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public interface SubjectService {

    List<TeacherSubject> selectBytchId(Long tchId, Byte role);
}
