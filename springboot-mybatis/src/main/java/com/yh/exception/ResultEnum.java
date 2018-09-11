package com.yh.exception;

/**
 * 全局返回包括异常返回枚举
 * Created by HR on 2018/5/9.
 */
public enum ResultEnum {

    SUCCESS(0, "success"),
    FAILURE(1, "failure"),
    UNKNOWN_ERROR(-1, "error"),
    UNAUTHENTICATED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden, lack of permissions"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private Integer code;
    private String msg;
}
