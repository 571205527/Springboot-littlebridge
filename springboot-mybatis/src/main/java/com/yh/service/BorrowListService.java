package com.yh.service;

import com.yh.entity.wrap.BorrowAmount;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public interface BorrowListService {

    List<BorrowAmount> getBorrowAmount(String cardNo, String start, String end);
    int getBookCount(Integer classYear, String start, String end);
}
