package com.yh.mapper;

import com.yh.entity.ECardLog;

public interface ECardLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ECardLog record);

    int insertSelective(ECardLog record);

    ECardLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ECardLog record);

    int updateByPrimaryKey(ECardLog record);
}