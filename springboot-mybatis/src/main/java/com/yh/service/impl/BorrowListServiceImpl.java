package com.yh.service.impl;

import com.yh.entity.wrap.BorrowAmount;
import com.yh.mapper.TlxxbMapper;
import com.yh.multiDataSource.DataSourceEnum;
import com.yh.multiDataSource.DataSourceTypeAnnotation;
import com.yh.service.BorrowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
@Service
public class BorrowListServiceImpl implements BorrowListService {

    @Autowired
    private TlxxbMapper tlxxbMapper;

    @Override
    @DataSourceTypeAnnotation(DataSourceEnum.Dblibrarynew)
    public List<BorrowAmount> getBorrowAmount(String cardNo, String start, String end) {
        return tlxxbMapper.getBorrowAmount(cardNo, start, end);
    }

    @Override
    @DataSourceTypeAnnotation(DataSourceEnum.Dblibrarynew)
    public int getBookCount(Integer classYear, String start, String end) {
        return tlxxbMapper.getBookCount(classYear, start, end);
    }
}
