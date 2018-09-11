package com.yh.service;

import java.text.ParseException;

/**
 * Created by HR on 2018/5/31.
 */
public interface ECardLogService {

    int insertECardLog(String cardNo, String eventLocation, String eventNote, String eventTime) throws ParseException;
}
