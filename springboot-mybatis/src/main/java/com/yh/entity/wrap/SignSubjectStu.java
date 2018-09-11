package com.yh.entity.wrap;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SignSubjectStu implements Serializable {
    private Long id;

    private Long schId;

    private Long tchId;

    private Long subId;

    private Long classId;

    private List<Long> stuIds;

    private Date signTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchId() {
        return schId;
    }

    public void setSchId(Long schId) {
        this.schId = schId;
    }

    public Long getTchId() {
        return tchId;
    }

    public void setTchId(Long tchId) {
        this.tchId = tchId;
    }

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public List<Long> getStuIds() {
        return stuIds;
    }

    public void setStuIds(List<Long> stuIds) {
        this.stuIds = stuIds;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }
}
