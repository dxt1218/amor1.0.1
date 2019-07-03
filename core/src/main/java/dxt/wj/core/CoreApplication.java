package dxt.wj.core;

import dxt.wj.core.models.CustomerBasic;
import dxt.wj.core.service.imp.CustomerServiceImp;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;

import java.util.Date;
import java.util.UUID;
@MapperScan(basePackages="dxt.wj.core.mapper.*")
@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        CustomerServiceImp customerServiceImp =new CustomerServiceImp();
        SpringApplication.run(CoreApplication.class, args);
        CustomerBasic customerBasic =new CustomerBasic();
        customerBasic.setCustomerId(UUID.randomUUID().toString());
        customerBasic.setCreateTime(new Date());
        customerBasic.setRealName("段祥天");
        customerBasic.setFlag("1");
        customerBasic.setLoginName("TTJJ");
        customerBasic.setLoginStatus("0");
        customerBasic.setPassword("1314521");
        customerBasic.setSex("1");
        boolean flag=customerServiceImp.save(customerBasic);
        System.out.println(flag);
    }

}
