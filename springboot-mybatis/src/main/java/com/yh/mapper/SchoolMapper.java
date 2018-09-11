package com.yh.mapper;

import com.yh.entity.School;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolMapper {
    int deleteByPrimaryKey(Long id);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}