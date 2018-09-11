package com.yh.entity.wrap;

import java.io.Serializable;

/**
 * Created by HR on 2018/6/4.
 */
public class ItemTimeStatisticsFollowTime implements Serializable{

    private String tagName;
//    private Integer award;
//    private Integer deduct;
    private Integer total;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

//    public Integer getAward() {
//        return award;
//    }
//
//    public void setAward(Integer award) {
//        this.award = award;
//    }
//
//    public Integer getDeduct() {
//        return deduct;
//    }
//
//    public void setDeduct(Integer deduct) {
//        this.deduct = deduct;
//    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
