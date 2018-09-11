package com.yh.entity.wrap;

import java.io.Serializable;

/**
 * @Created by: LHZ
 * @Description: 签到权限说明及角色
 */
public class SignPrivilege implements Serializable {

    private Byte role;//角色
    private Integer state;//兴趣课权限值
    private String comment;

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
