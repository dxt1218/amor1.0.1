package dxt.wj.core.demo;

import dxt.wj.core.CoreApplication;
import dxt.wj.core.models.CustomerBasic;
import dxt.wj.core.service.imp.CustomerServiceImp;
import org.springframework.boot.SpringApplication;

import java.util.Date;
import java.util.UUID;

public class TestClass {
    public static void main(String[] args) {
        CustomerServiceImp customerServiceImp =new CustomerServiceImp();
        CustomerBasic customerBasic =new CustomerBasic();
        customerBasic.setCustomerId(UUID.randomUUID().toString());
        customerBasic.setCreateTime(new Date());
        customerBasic.setRealName("段祥天");
        customerBasic.setFlag("1");
        customerBasic.setLoginName("TTJJ");
        customerBasic.setLoginStatus("0");
        customerBasic.setPassword("1314521");
        customerBasic.setSex("1");
        System.out.println(customerBasic.toString());
        customerServiceImp.selectById(customerBasic);
        //customerServiceImp.insert(customerBasic);
    }
}
