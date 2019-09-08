package dxt.wj.customer.models.dto;

import lombok.Data;

/**
 * 时间 参数
 * 纪念日
 * */
@Data
public class DateParam {

    /**
     * 天数
     * */
    private  int day;
    /**
     * 开始日期
     * */
    private  String startDate;
    /**
     * 现在日期
     * */
    private  String nowDate;

}
