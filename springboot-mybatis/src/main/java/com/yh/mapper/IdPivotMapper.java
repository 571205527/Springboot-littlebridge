package com.yh.mapper;

import com.yh.entity.IdPivot;
import com.yh.entity.wrap.EventContent;
import com.yh.entity.wrap.GrowReport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IdPivotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IdPivot record);

    int insertSelective(IdPivot record);

    IdPivot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IdPivot record);

    int updateByPrimaryKey(IdPivot record);

    List<GrowReport> getCardNo();

    EventContent getCardNoByStuId(@Param("stuId") Long stuId);
}