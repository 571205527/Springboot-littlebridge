package com.yh.multiDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HR on 2018/5/3.
 */
public class DataSourceContextHolder {

    //默认给本地线程副本edu_base值
    private static final ThreadLocal<DataSourceEnum> CONTEXT_HOLDER = new ThreadLocal<DataSourceEnum>(){
        @Override
        protected DataSourceEnum initialValue() {
            return DataSourceEnum.edu_zq;
        }
    };

    public static void setDataSourceType(DataSourceEnum type){
        CONTEXT_HOLDER.set(type);
    }

    public static DataSourceEnum getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    public static void resetDataSourceType(){
        CONTEXT_HOLDER.set(DataSourceEnum.edu_zq);
    }

}
