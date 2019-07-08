package dxt.wj.core.service.imp;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dxt.wj.core.mapper.CustomerMapper;
import dxt.wj.core.models.CustomerBasic;
import dxt.wj.core.service.CustomerService;
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
