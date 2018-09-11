package com.yh.mapper;

import com.yh.entity.Tag;
import com.yh.entity.wrap.TagEventItem;
import com.yh.entity.wrap.TagItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(@RequestBody Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    //根据评价标签id获取相应评价项
    List<TagItem> getAssessItemByTagId(@Param("tagId") Long tagId);

    List<TagEventItem> getEventItem(@Param("tagId") Long tagId);

    //显示标签
    List<Tag> selectByTagType(@Param("type") Byte type);
}