package com.yh.entity.wrap;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HR on 2018/5/16.
 */
public class GradeClassStudents implements Serializable {

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public List<ClassStudents> getClassStudentses() {
        return classStudentses;
    }

    public void setClassStudentses(List<ClassStudents> classStudentses) {
        this.classStudentses = classStudentses;
    }

    private Integer grade;
    private List<ClassStudents> classStudentses;
}
