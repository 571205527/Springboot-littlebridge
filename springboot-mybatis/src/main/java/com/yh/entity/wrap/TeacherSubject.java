package com.yh.entity.wrap;

import com.yh.entity.Teacher;

import java.io.Serializable;
import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public class TeacherSubject implements Serializable {

    private Integer subId;
    private String subName;
    //private String classRoom;
    /*private Integer tchId;
    private String tchName;*/
    private List<Teacher> teachers;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
    /*public Integer getTchId() {
        return tchId;
    }

    public void setTchId(Integer tchId) {
        this.tchId = tchId;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }*/

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
