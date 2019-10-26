package dxt.wj.customer.config;

import lombok.Data;

/**
 *  mail 处理参数配置实体
 * @author dxt
 * @date 2019年10月20日21:43:47
 * */
@Data
public class EmailParam {

    private String host; // smtp.qq.com #发送邮件服务器

    private String userName;// #发送邮件的邮箱地址

    private String password;// #客户端授权码，不是邮箱密码,网易的是自己设置的,QQ的话在邮箱设置

    /**
     * QQ 的 properties.mail.smtp.port: 465 #端口号465或587
     * 网易  994  465
     * */
    private String mailSmtpPort;

    private String from; //和userName同名

}
