package com.yh.mapper;

import com.yh.entity.AssessItem;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AssessItem record);

    int insertSelective(AssessItem record);

    AssessItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssessItem record);

    int updateByPrimaryKey(AssessItem record);

}