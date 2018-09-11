package com.yh.entity.wrap;

/**
 * @Created by: LHZ
 * @Description:
 */
public class AverageScore {

    private String lateAvg;//迟到
    private String absentAvg;//请假
    private String deductAvg;//加分
    private String awardAvg;//减分
    private String bookAvg;//借书

    public String getLateAvg() {
        return lateAvg;
    }

    public void setLateAvg(String lateAvg) {
        this.lateAvg = lateAvg;
    }

    public String getAbsentAvg() {
        return absentAvg;
    }

    public void setAbsentAvg(String absentAvg) {
        this.absentAvg = absentAvg;
    }

    public String getDeductAvg() {
        return deductAvg;
    }

    public void setDeductAvg(String deductAvg) {
        this.deductAvg = deductAvg;
    }

    public String getAwardAvg() {
        return awardAvg;
    }

    public void setAwardAvg(String awardAvg) {
        this.awardAvg = awardAvg;
    }

    public String getBookAvg() {
        return bookAvg;
    }

    public void setBookAvg(String bookAvg) {
        this.bookAvg = bookAvg;
    }
}
