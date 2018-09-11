package com.yh.entity.wrap;

import com.yh.util.BaseUtil;

import java.io.Serializable;

/**
 * Created by HR on 2018/5/17.
 */
public class StudentStatistics implements Serializable {

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        /*switch(getClassNo()){
            case 1:this.className = getGradeName()+"一班 Grade"+getGrade()+" Class 1";break;
            case 2:this.className = getGradeName()+"二班 Grade"+getGrade()+" Class 2";break;
            case 3:this.className = getGradeName()+"三班 Grade"+BaseUtil.gradeToChinese(getGrade())+" Class 3";break;
            case 4:this.className = getGradeName()+"四班 Grade"+BaseUtil.gradeToChinese(getGrade())+" Class 4";break;
            case 5:this.className = getGradeName()+"五班 Grade"+BaseUtil.gradeToChinese(getGrade())+" Class 5";break;
            case 6:this.className = getGradeName()+"六班 Grade"+BaseUtil.gradeToChinese(getGrade())+" Class 6";break;
            default:this.className = className;break;
        }*/
        className = BaseUtil.classToChinese(getGrade(),getClassNo());
        this.className = className;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        gradeName = getGrade()+"年级";
        System.out.println(gradeName+"=================");
        this.gradeName = gradeName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        //grade = BaseUtil.gradeToChinese(grade);
        this.grade = grade;
    }

    public Byte getStuNo() {
        return stuNo;
    }

    public void setStuNo(Byte stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public Integer getDeduct() {
        return deduct;
    }

    public void setDeduct(Integer deduct) {
        this.deduct = deduct;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname;
    }

    private Integer classNo;
    private Integer grade;
    private String gradeName;
    private String className;
    private Byte stuNo;
    private String stuName;
    private String stuNickname;
    private Integer award;
    private Integer deduct;
    private Integer total;
}
