package annotation;

import java.lang.annotation.*;

/**
 * 自定义系统日志注解
 * */
@Target(ElementType.METHOD) //注解目标（方法上，类上）
@Documented
@Retention(RetentionPolicy.RUNTIME)//编译生效
public @interface SysLog {
    /**方法名*/
    String value() default "";
    /**模块名*/
    String moduleName() default "";
}
