package com.yh.service;

import com.yh.entity.Tag;
import com.yh.entity.wrap.TagEventItem;
import com.yh.entity.wrap.TagItem;

import java.util.List;

/**
 * @author: LHZ
 * @Description:
 * @Date: 17:32 2018/5/17
 */
public interface TagService {

    //根据评价标签id获取相应评价项
    List<TagItem> getAssessItemByTagId(Long tagId);

    //获取事件子标签
    List<TagEventItem> getEventItem(Long tagId);

    //显示标签
    List<Tag> selectByTagType(Byte type);

}
