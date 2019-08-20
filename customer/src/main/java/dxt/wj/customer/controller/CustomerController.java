package dxt.wj.customer.controller;

import dxt.wj.customer.models.dto.ParamList;
import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.imp.CustomerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/aa/")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerServiceImp customerService;

    @Autowired
    RedisTemplate redisTemplate;

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
    @GetMapping("test")
    public String redisTes(){
        List<CustomerBasic> list =customerService.list();
        long num =redisTemplate.opsForList().rightPush("list",list);
        redisTemplate.opsForList().rightPush("lis2",list);
        redisTemplate.opsForList().rightPush("lis2",list);
        redisTemplate.opsForList().rightPush("lis2",list);
        List aa= (List) redisTemplate.opsForList().rightPop("list");
        System.out.println("集合:"+aa.toString());
        //String str=redisTemplate.opsForValue().get(list.get(0).getCustomerId());
      /*  System.out.println("str:"+str);
        redisTemplate.opsForValue().append(list.get(0).getCustomerId(),"+++嘿嘿");
        System.out.println("新：==="+redisTemplate.opsForValue().get(list.get(0).getCustomerId()));*/
        return aa.toString();
    }
}
