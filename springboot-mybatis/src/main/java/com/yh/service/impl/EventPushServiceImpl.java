package com.yh.service.impl;

import com.yh.entity.PushLog;
import com.yh.entity.Student;
import com.yh.entity.Teacher;
import com.yh.entity.wrap.EventContent;
import com.yh.entity.wrap.GrowReport;
import com.yh.mapper.IdPivotMapper;
import com.yh.mapper.PushLogMapper;
import com.yh.mapper.StudentMapper;
import com.yh.mapper.TeacherMapper;
import com.yh.service.EventPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
@Service
public class EventPushServiceImpl implements EventPushService {

    @Autowired
    private TeacherMapper tchMapper;

    @Autowired
    private IdPivotMapper idPivotMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private PushLogMapper pushLogMapper;

    @Override
    public Student selectById(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(PushLog record) {
        return pushLogMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(PushLog record) {
        return pushLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Teacher selectByPrimaryKey(Long id) {
        return tchMapper.selectByPrimaryKey(id);
    }

    @Override
    public EventContent getCardNoByStuId(Long stuId) {
        return idPivotMapper.getCardNoByStuId(stuId);
    }

    @Override
    public int countStu(Integer classYear) {
        return studentMapper.countStu(classYear);
    }

    @Override
    public List<GrowReport> getCardNo() {
        return idPivotMapper.getCardNo();
    }
}
