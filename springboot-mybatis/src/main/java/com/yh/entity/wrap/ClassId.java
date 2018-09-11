package com.yh.entity.wrap;

import com.yh.util.BaseUtil;

import java.io.Serializable;

/**
 * @Created by: LHZ
 * @Description:
 */
public class ClassId implements Serializable{

    private Long id;
    private Integer grade;
    private Integer classNo;
    private String className;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        //Integer gradeNo = BaseUtil.gradeToChinese(Integer.valueOf(grade));
        //className = BaseUtil.classToChinese(getGrade(),getClassNo());
        switch(getClassNo()){
            case 1:this.className = "一班 Class 1";break;
            case 2:this.className = "二班 Class 2";break;
            case 3:this.className = "三班 Class 3";break;
            case 4:this.className = "四班 Class 4";break;
            case 5:this.className = "五班 Class 5";break;
            case 6:this.className = "六班 Class 6";break;
            default:this.className = className;break;
        }
    }
}
