package com.yh.service;

import com.yh.entity.PushLog;
import com.yh.entity.Student;
import com.yh.entity.Teacher;
import com.yh.entity.wrap.EventContent;
import com.yh.entity.wrap.GrowReport;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public interface EventPushService {

    Student selectById(Long id);

    //事件推送log
    int insertSelective(PushLog record);
    int updateByPrimaryKeySelective(PushLog record);

    //事件推送
    Teacher selectByPrimaryKey(Long id);
    EventContent getCardNoByStuId(Long stuId);

    //成长报告推送
    int countStu(Integer classYear);
    List<GrowReport> getCardNo();
}
