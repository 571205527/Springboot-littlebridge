package com.yh.entity.wrap;


import java.io.Serializable;

/**
 * 年级信息
 * Created by HR on 2018/5/16.
 */
public class Grade implements Serializable {

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Integer createDt) {
        this.createDt = createDt;
    }

    private Integer gradeId;
    private String gradeName;
    private Integer createDt;
}
