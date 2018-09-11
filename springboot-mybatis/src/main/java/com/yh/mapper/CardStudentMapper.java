package com.yh.mapper;

import com.yh.entity.CardStudent;

public interface CardStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CardStudent record);

    int insertSelective(CardStudent record);

    CardStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CardStudent record);

    int updateByPrimaryKey(CardStudent record);
}