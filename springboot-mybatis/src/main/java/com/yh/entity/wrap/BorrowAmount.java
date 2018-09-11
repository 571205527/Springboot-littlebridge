package com.yh.entity.wrap;

import java.io.Serializable;

/**
 * @Created by: LHZ
 * @Description:
 */
public class BorrowAmount implements Serializable {

    //private Integer 月份;
    private String 读者证号;
    private String 读者姓名;
    private String 读者单位;
    private Integer 借书数量;

    public String get读者证号() {
        return 读者证号;
    }

    public void set读者证号(String 读者证号) {
        this.读者证号 = 读者证号;
    }

    public String get读者姓名() {
        return 读者姓名;
    }

    public void set读者姓名(String 读者姓名) {
        this.读者姓名 = 读者姓名;
    }

    public String get读者单位() {
        return 读者单位;
    }

    public void set读者单位(String 读者单位) {
        this.读者单位 = 读者单位;
    }

    public Integer get借书数量() {
        return 借书数量;
    }

    public void set借书数量(Integer 借书数量) {
        this.借书数量 = 借书数量;
    }
}
