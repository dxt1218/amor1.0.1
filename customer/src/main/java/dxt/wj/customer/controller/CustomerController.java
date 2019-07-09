package dxt.wj.customer.controller;

import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    CustomerServiceImp customerService;
    @RequestMapping("/aa")
    public void ins(){
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
       // customerService.instCu(customerBasic);
        customerService.instCu(customerBasic);
    }
}
