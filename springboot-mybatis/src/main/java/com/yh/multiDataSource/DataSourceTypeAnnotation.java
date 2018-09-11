package com.yh.multiDataSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据源类型注解
 * Created by HR on 2018/5/3.
 */
@Retention(RetentionPolicy.RUNTIME) // 在运行时可见
@Target(ElementType.METHOD) // 注解可以用在方法上
public @interface DataSourceTypeAnnotation {

    DataSourceEnum value() default DataSourceEnum.edu_zq;
}
