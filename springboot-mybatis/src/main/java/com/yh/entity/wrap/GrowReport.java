package com.yh.entity.wrap;

import java.io.Serializable;
import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public class GrowReport implements Serializable {

    private Long stuId;
    private Long classId;
    private String className;
    private String cardNo;
    private String stuName;
    private String stuNickname;
    private AverageScore averageScore;
    private ItemPowerStatistics itemStatisticsList;
    private BorrowAmount borrowAmounts;
    private List<SignStatistics> signList;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickame(String stuNickname) {
        this.stuNickname = stuNickname;
    }

    public ItemPowerStatistics getItemStatisticsList() {
        return itemStatisticsList;
    }

    public void setItemStatisticsList(ItemPowerStatistics itemStatisticsList) {
        this.itemStatisticsList = itemStatisticsList;
    }

    public BorrowAmount getBorrowAmounts() {
        return borrowAmounts;
    }

    public void setBorrowAmounts(BorrowAmount borrowAmounts) {
        this.borrowAmounts = borrowAmounts;
    }

    public List<SignStatistics> getSignList() {
        return signList;
    }

    public void setSignList(List<SignStatistics> signList) {
        this.signList = signList;
    }

    public AverageScore getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(AverageScore averageScore) {
        this.averageScore = averageScore;
    }
}
