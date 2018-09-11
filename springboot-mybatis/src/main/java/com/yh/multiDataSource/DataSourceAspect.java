package com.yh.multiDataSource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * 捕获使用数据源注解的方法，并且根据注解上的数据源类型进行切换
 * Created by HR on 2018/5/3.
 */
@Component
@Aspect
public class DataSourceAspect {

    //this can not scan mapper packages!
    @Pointcut("execution(* com.yh.service..*(..))" + "&& @annotation(com.yh.multiDataSource.DataSourceTypeAnnotation)")
    public void dataSourcePointcut(){
    }

    @Around("dataSourcePointcut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method =  methodSignature.getMethod();
        DataSourceTypeAnnotation type = method.getAnnotation(DataSourceTypeAnnotation.class);
        //获取当前的指定的数据源
        DataSourceEnum dataSource = type.value();
        //如果不在我们注入的所有的数据源范围之内，那么输出警告信息，系统自动使用默认的数据源。
        if (dataSource == DataSourceEnum.edu_zq){
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.edu_zq);
        }else if (dataSource == DataSourceEnum.Dblibrarynew){
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.Dblibrarynew);
        }else if (dataSource == DataSourceEnum.local){
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.local);
        }

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
            DataSourceContextHolder.resetDataSourceType();
        }
        return result;
    }

}
