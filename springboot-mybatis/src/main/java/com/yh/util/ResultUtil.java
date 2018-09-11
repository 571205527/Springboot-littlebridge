package com.yh.util;

import com.yh.exception.ResultEnum;

/**
 * Created by HR on 2018/5/8.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result failure(Integer code, String msg,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }


    public static Result failure(){
        Result result = new Result();
        result.setCode(ResultEnum.FAILURE.getCode());
        result.setMsg(ResultEnum.FAILURE.getMsg());
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
