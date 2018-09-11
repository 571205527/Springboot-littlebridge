package com.yh.mapper;

import com.yh.entity.EventItem;

public interface EventItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EventItem record);

    int insertSelective(EventItem record);

    EventItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EventItem record);

    int updateByPrimaryKey(EventItem record);
}