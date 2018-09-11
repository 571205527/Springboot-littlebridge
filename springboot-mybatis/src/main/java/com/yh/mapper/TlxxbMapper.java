package com.yh.mapper;

import com.yh.entity.Tlxxb;
import com.yh.entity.wrap.BorrowAmount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TlxxbMapper {
    int deleteByPrimaryKey(Integer 标识列);

    int insert(Tlxxb record);

    int insertSelective(Tlxxb record);

    Tlxxb selectByPrimaryKey(Integer 标识列);

    int updateByPrimaryKeySelective(Tlxxb record);

    int updateByPrimaryKeyWithBLOBs(Tlxxb record);

    int updateByPrimaryKey(Tlxxb record);

    List<BorrowAmount> getBorrowAmount(@Param("cardNo") String cardNo, @Param("start") String start, @Param("end") String end);
    int getBookCount(@Param("classYear") Integer classYear, @Param("start") String start, @Param("end") String end);
}