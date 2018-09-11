package com.yh.controller;

import com.yh.entity.Tag;
import com.yh.entity.wrap.TagEventItem;
import com.yh.entity.wrap.TagItem;
import com.yh.exception.ResultEnum;
import com.yh.exception.SystemException;
import com.yh.mapper.AssessLogMapper;
import com.yh.mapper.EventLogMapper;
import com.yh.service.TagService;
import com.yh.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: LHZ
 * @Description:
 * @Date: 17:33 2018/5/17
 */
@RestController
@RequestMapping("/v1/tag")
public class TagController {
    private static final Logger log = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

    @Autowired
    private AssessLogMapper assessLogMapper;

    @Autowired
    EventLogMapper eventLogMapper;

    /**
     * @return java.lang.Object
     * @Description 通过item表中的tag_id获取评价项
     * @Date 2018/5/17
     * @Param [tagId]
     */
    @RequestMapping("/{tagId}/tagItem")
    public Object getItemInfo(@PathVariable("tagId") Long tagId) {
        try {
            if (!tagId.equals("")||tagId!=null){
                log.info("items Info...");
                List<TagItem> items = tagService.getAssessItemByTagId(tagId);
                log.info("items size:" + items.size());
                return ResultUtil.success(items);
            }
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(),"获取评价项失败！");
        }
        return ResultUtil.failure();
    }

    /**
     * 通过tag表中的标签类型获取标签
     * 1-能量站评价标签（评价标签+事件标签）  2-事件标签
     */
    @RequestMapping("/{type}/{tchId}")
    public Object getTagInfo(@PathVariable("type") Byte type) {
        try {
            List<Tag> tag = tagService.selectByTagType(type);
            log.info("tag Info:" + type);
            return ResultUtil.success(tag);
        }catch (Exception e){
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "评价标签获取失败："+e.getMessage());
        }
    }

    /**
     * 通过tag表中的标签类型获取标签
     * 1-能量站评价标签  2-事件标签
     */
    /*@RequestMapping("/tagItems/{type}/{tagId}")
    public Object getTagItemInfo(@PathVariable("type") Byte type,
                                 @PathVariable("tagId") Long tagId) {
        try {
            if (type == 1){
                List<TagItem> items = tagService.getAssessItemByTagId(tagId);
                return ResultUtil.success(items);
            }else if (type == 2 || type == 3){
                List<TagEventItem> items = tagService.getEventItem(tagId);
                return ResultUtil.success(items);
            }
        }catch (Exception e){
            throw new SystemException(ResultEnum.UNKNOWN_ERROR.getCode(), "评价标签获取失败："+e.getMessage());
        }
        return ResultUtil.failure();
    }*/
}
