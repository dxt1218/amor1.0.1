package dxt.wj.customer.service.imp;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dxt.wj.customer.mapper.CustomerMapper;
import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImp  extends ServiceImpl<CustomerMapper, CustomerBasic> implements CustomerService {
    @Resource
    CustomerMapper customerMapper;
    @Override
    public int instCu(CustomerBasic customerBasic) {
        return customerMapper.instCu(customerBasic);
    }
}
