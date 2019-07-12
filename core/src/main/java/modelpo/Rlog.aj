package modelpo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 日志参数
 * */
@Data
public class Rlog implements Serializable {
    /**
     * 方法操作名
     * */
    private String name;

    /**
     * 请求路径
     * */
    private String requestUrl;

    /**
     * 请求类型
     * */
    private String requestType;


    /**
     * 请求参数
     * */
    private String requestParam;

    /**
     * 请求参数
     * */
    private String requestBody;

    /**
     * 请求用户
     * */
    private String userName;

    /**
     * 花费时间
     * */
    private Long usedTime;

    /**
     * 开始时间
     * */
    private String startTime;

    /**
     * 结束
     * */
    private String endTime;
    /**
     * 转换请求参数为json
     * */
    public void setMapToParam(Map<String,String[]> paramMap){
        this.requestParam= JSON.toJSONString(paramMap);
    }
}
