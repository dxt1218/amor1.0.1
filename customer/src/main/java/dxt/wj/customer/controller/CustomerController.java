package dxt.wj.customer.controller;

import dxt.wj.customer.models.dto.ParamList;
import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.imp.CustomerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/aa/")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerServiceImp customerService;
    @PostMapping("bb")
    public void ins(@RequestBody CustomerBasic customerBasic){
        customerService.instCu(customerBasic);
    }
    @PostMapping("add")
    public int add(@RequestBody List<CustomerBasic> customerBasic){
        //ParamList paramList =new ParamList();
        Map<String,String>map=customerService.getAnnotationsVules(new CustomerBasic());
        log.info("map:"+map.toString());
        int count=customerService.insetBatchCust(customerBasic);
        log.info("插入："+count+"条");
        return count;
    }
}
