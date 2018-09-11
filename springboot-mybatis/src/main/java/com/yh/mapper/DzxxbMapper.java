package com.yh.mapper;

import com.yh.entity.Dzxxb;
import com.yh.entity.DzxxbWithBLOBs;

public interface DzxxbMapper {
    int deleteByPrimaryKey(Integer 标识列);

    int insert(DzxxbWithBLOBs record);

    int insertSelective(DzxxbWithBLOBs record);

    DzxxbWithBLOBs selectByPrimaryKey(Integer 标识列);

    int updateByPrimaryKeySelective(DzxxbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DzxxbWithBLOBs record);

    int updateByPrimaryKey(Dzxxb record);
}