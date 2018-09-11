package com.yh.mapper;

import com.yh.entity.TeacherAgenda;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherAgendaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TeacherAgenda record);

    int insertSelective(TeacherAgenda record);

    TeacherAgenda selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TeacherAgenda record);

    int updateByPrimaryKey(TeacherAgenda record);
}