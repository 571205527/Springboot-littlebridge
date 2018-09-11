package com.yh.service.impl;

import com.yh.entity.ECardLog;
import com.yh.mapper.ECardLogMapper;
import com.yh.service.ECardLogService;
import com.yh.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by HR on 2018/5/31.
 */
@Service
public class ECardLogServiceImpl implements ECardLogService {

    @Autowired
    private ECardLogMapper eCardLogMapper;


    @Override
    public int insertECardLog(String cardNo, String eventLocation, String eventNote, String eventTime) throws ParseException {

        ECardLog eCardLog = new ECardLog();

        eCardLog.setCardNo(cardNo);
        eCardLog.setEventLocation(eventLocation);
        eCardLog.setEventNote(eventNote);
        eCardLog.setEventTime(BaseUtil.stringToDate(eventTime));

        return eCardLogMapper.insertSelective(eCardLog);
    }
}
