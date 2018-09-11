package com.yh.mapper;

import com.yh.entity.Class;
import com.yh.entity.wrap.GradeClassStudents;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Long id);

    List<Class> getAllClass();

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<GradeClassStudents> getClassStudents(@Param("schId") Long schId);
}