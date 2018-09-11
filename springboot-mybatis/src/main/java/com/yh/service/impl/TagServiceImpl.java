package com.yh.service.impl;

import com.yh.entity.Tag;
import com.yh.entity.wrap.TagEventItem;
import com.yh.entity.wrap.TagItem;
import com.yh.mapper.TagMapper;
import com.yh.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: LHZ
 * @Description:
 * @Date: 17:35 2018/5/17
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<TagItem> getAssessItemByTagId(Long tagId) {
        return tagMapper.getAssessItemByTagId(tagId);
    }

    @Override
    public List<TagEventItem> getEventItem(Long tagId) {
        return tagMapper.getEventItem(tagId);
    }

    @Override
    public List<Tag> selectByTagType(Byte type) {
        return tagMapper.selectByTagType(type);
    }

}
