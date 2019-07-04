package dxt.wj.core.service.imp;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import dxt.wj.core.mapper.CustomerMapper;
import dxt.wj.core.models.CustomerBasic;
import dxt.wj.core.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp  extends ServiceImpl<CustomerMapper, CustomerBasic> implements CustomerService {

}
