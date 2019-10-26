package dxt.wj.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * emali 配置类 初始化bean
 * @author dxt
 * @date 2019年10月20日22:36:57
 * */

@Configuration
public class EmailConfig {
    /**
    * email 配置  QQ 网易邮箱
    * */
    @Bean(name = "mailList")
    public Map<String,EmailParam> getEmail(){
        EmailParam qq = new EmailParam();
        EmailParam we = new EmailParam();
        Map<String,EmailParam> mailList = new HashMap<>();
        mailList.put("QQ",qq);
        mailList.put("WANGYI",we);

        return  mailList;

    }
}
