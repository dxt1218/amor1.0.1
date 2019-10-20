package dxt.wj.customer.config;

import lombok.Data;

/**
 *  mail 处理参数实体
 * @author dxt
 * @date 2019年10月20日21:43:47
 * */
@Data
public class EmailParam {

    private String host;

    private String userName;

    private String password;

    private String mailSmtpPort;

    private String from;

}
