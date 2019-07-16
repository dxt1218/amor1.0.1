package logAspect;


import annotation.SysLog;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import modelpo.RLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;
import java.util.Map;

/**
 * 日志切面
 * */
@Slf4j
public class LogAspect {
    private  static final ThreadLocal<Long> beginTimeThreadLocal = new ThreadLocal<Long>();//泛型定义 线程里的类型
    // 结束时间
    private long endTime = 0L;

    //请求
    @Autowired(required=false)//不强行注入
    private HttpServletRequest request;
    // 获取request
    /*RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
    HttpServletRequest request = servletRequestAttributes.getRequest();*/

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
        RLog rlog =new RLog();
        try {
            Date beginTime=new Date();
            //线程绑定变量（date）
            beginTimeThreadLocal.set(beginTime.getTime());
            //TODO 获取用户信息 当前无法获取
            result = joinPoint.proceed();//执行被环绕的对象
            //方法说明
            rlog.setName(getSysLog(joinPoint));
            endTime= System.currentTimeMillis();
            //消耗时间
            rlog.setUsedTime(endTime-beginTimeThreadLocal.get());
            //url
            rlog.setRequestUrl(request.getRequestURI());
            //请求方式（get，POST）
            rlog.setRequestType(request.getMethod());
            Map<String,String[]>params =request.getParameterMap();//获取请求参数
            if(log.isDebugEnabled()){//预防在日志等级高于DeBug的情况下
                rlog.setMapToParam(params);
            }
            if(getBodyParam(joinPoint)!=null){
                rlog.setRequestBody(JSON.toJSONString(getBodyParam(joinPoint)));
            }
            log.info(rlog.toString());
        } catch (Throwable throwable) {
            log.error("请求"+rlog.toString());
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
        //获取相关参数
        Object []params=joinPoint.getArgs();
        for(Method method:methods){
            if(method.getName().equals(targetMethodName)){
                Class[] classParams = method.getParameterTypes();//获取方法参数数组
                if(classParams.length==params.length){ //判断参数个数是否相同  方法的重载 方法名相同参数不同
                    if(method.getAnnotation(SysLog.class)!=null){ //从注解中获取参数说明
                       name=method.getAnnotation(SysLog.class).value();
                       break;
                    }
                }
            }
        }
        return name;
    }


    /**
     * 获取方法的body参数
     * */
    Object getBodyParam(ProceedingJoinPoint joinPoint){
        //获取目标对象
        Class targetClass = joinPoint.getTarget().getClass();
        //获取进入的方法
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        StringBuffer sb =new StringBuffer();
        String bodyName ="";
        for(Parameter parameter:methodSignature.getMethod().getParameters()){
            if(parameter.getAnnotation(RequestBody.class)!=null){
                bodyName=parameter.getParameterizedType().getTypeName();//获得参数名
            }
        }
        if(joinPoint.getArgs()!=null&&joinPoint.getArgs().length>0){
            for(Object obj:joinPoint.getArgs()){
                if(bodyName.equals(obj.getClass().getName())&& !StringUtils.isEmpty(bodyName)){
                    return obj;
                }
            }
        }
        return null;
    }
}