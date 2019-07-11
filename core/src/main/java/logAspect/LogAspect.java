package logAspect;


import lombok.extern.slf4j.Slf4j;
import models.Rlog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志切面
 * */
@Slf4j
public class LogAspect {
    private  static final ThreadLocal<Date> beginTimeThreadLocal = new ThreadLocal<Date>();//泛型定义 线程里的类型

    //请求
    @Autowired(required=false)//不强行注入
    private HttpServletRequest request;


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
        try {
            Rlog rlog =new Rlog();
            Date beginTime=new Date();
            //线程绑定变量（date）
            beginTimeThreadLocal.set(beginTime);
            //TODO 获取用户信息 当前无法获取
            result = joinPoint.proceed();//执行被环绕的对象
            log.info("joinPoint.proceed()==="+result.toString());
            rlog.setName(getSysLog(joinPoint));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }


    /**获取注解说明*/
    public static String getSysLog(ProceedingJoinPoint joinPoint) throws ClassNotFoundException {
        String name ="";
        //目标完整类名
        String className=joinPoint.getTarget().getClass().getName();
        //获取方法名 （getName）
        String targetMethodName =joinPoint.getSignature().getName();
        //生成类对象
        Class targetClass = Class.forName(className);
        //获取类方法
        Method []methods=targetClass.getMethods();
        for(Method method:methods){

        }
        return name;
    }
}