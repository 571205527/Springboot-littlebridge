package com.yh.mapper;

import com.yh.entity.Subject;
import com.yh.entity.wrap.TeacherSubject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    List<TeacherSubject> selectBytchId(@Param("tchId") Long tchId, @Param("role") Byte role);
}