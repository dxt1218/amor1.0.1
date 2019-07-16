package dxt.wj.customer.logAspect;

import logAspect.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切面
 * */
@Aspect
@Slf4j
@Component
public class CustrollerAspect extends LogAspect {
    private  static final ThreadLocal<Long> beginTimeThreadLocal = new ThreadLocal<Long>();//泛型定义 线程里的类型

    //请求
    @Autowired(required=false)//不强行注入
    private HttpServletRequest request;


    //业务层日志
    @Pointcut("execution(* dxt.wj.customer.controller..*(..))")
    public void contorllerAspect(){

    }
    //对外层日志
    public void apiAspect(){}
}
