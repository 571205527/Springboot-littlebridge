package com.yh.exception;


/**
 * 自定义异常
 * Created by HR on 2018/5/8.
 */
public class SystemException extends RuntimeException {

    private Integer code;

    public SystemException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
