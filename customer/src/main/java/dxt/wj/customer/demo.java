package dxt.wj.customer;

import dxt.wj.customer.models.CustomerBasic;
import dxt.wj.customer.service.imp.CustomerServiceImp;

import java.util.Date;
import java.util.UUID;

public class demo {
    public static void main(String[] args) {
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
        CustomerServiceImp customerServiceImp =new CustomerServiceImp();
        customerServiceImp.instCu(customerBasic);
    }

}

