package dxt.wj.customer.logAspect;

import java.util.Date;

/**
 * 日志切面
 * */
public class LogAspect {
    private  static final ThreadLocal<Date> beginTimeThreadLocal =new ThreadLocal<Date>();
}
