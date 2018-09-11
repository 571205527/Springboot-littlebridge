package com.yh.entity.wrap;

import com.yh.entity.Student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HR on 2018/5/16.
 */
public class ClassStudents implements Serializable {

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getSchId() {
        return schId;
    }

    public void setSchId(Long schId) {
        this.schId = schId;
    }

    public Short getClassYear() {
        return classYear;
    }

    public void setClassYear(Short classYear) {
        this.classYear = classYear;
    }

    public Byte getClassNo() {
        return classNo;
    }

    public void setClassNo(Byte classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
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

    public String getClassNickname() {
        return classNickname;
    }

    public void setClassNickname(String classNickname) {
        this.classNickname = classNickname;
    }

    public String getClassIcon() {
        return classIcon;
    }

    public void setClassIcon(String classIcon) {
        this.classIcon = classIcon;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private Long schId;

    private Long classId;

    private Short classYear;

    private Byte classNo;

    private String className;

    private String classNickname;

    private String classIcon;

    private List<Student> students = new ArrayList<>();

    private static final long serialVersionUID = 1L;
}
