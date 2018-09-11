package com.yh.mapper;

import com.yh.entity.PushLog;

public interface PushLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PushLog record);

    int insertSelective(PushLog record);

    PushLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PushLog record);

    int updateByPrimaryKey(PushLog record);
}