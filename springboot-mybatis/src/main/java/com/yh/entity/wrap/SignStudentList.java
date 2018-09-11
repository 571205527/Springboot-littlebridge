package com.yh.entity.wrap;

import com.yh.entity.Student;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Created by: LHZ
 * @Description:
 */
public class SignStudentList implements Serializable {

    private Integer signId;
    //private String subName;
    //private String tchName;
    private String signTime;
    private Integer classId;
    private String className;
    private List<Student> students;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getSignId() {
        return signId;
    }

    public void setSignId(Integer signId) {
        this.signId = signId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(signTime);
            this.signTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
