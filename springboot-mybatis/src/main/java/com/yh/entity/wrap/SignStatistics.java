package com.yh.entity.wrap;

import com.yh.util.BaseUtil;

import java.io.Serializable;

/**
 * @Created by: LHZ
 * @Description:
 */
public class SignStatistics implements Serializable {

    private Integer id;
    private String subName;
    private Integer classNo;
    private Integer grade;
    private String className;
    private String stuName;
    private String stuNickname;
    private Integer count;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        if (className != null) {
            className = BaseUtil.classToChinese(getGrade(), getClassNo());
        }
        this.className = className;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getStuNickname() {
        return stuNickname;
    }

    public void setStuNickname(String stuNickname) {
        this.stuNickname = stuNickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
