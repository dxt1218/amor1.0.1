package logAspect;

import models.Rlog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import java.util.Date;

/**
 * 日志切面
 * */
public class LogAspect {
    private  static final ThreadLocal<Date> beginTimeThreadLocal = new ThreadLocal<Date>();//泛型定义 线程里的类型

    //请求

    //业务层日志
    public void contorllerAspect(){

    }
    //对外层日志
    public void apiAspect(){}

    /**
     * @param joinPoint 切点
     *      ProceedingJoinPoint  配合around环绕
     * */
    @Around("contorllerAspect()")
    public Object doContorller(ProceedingJoinPoint joinPoint){
        Object result = null;
        Rlog rlog =new Rlog();
        Date beginTime=new Date();
        beginTimeThreadLocal.set(beginTime);

        return result;
    }
}