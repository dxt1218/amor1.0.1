package dxt.wj.customer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import dxt.wj.customer.models.CustomerBasic;

public interface CustomerService extends IService<CustomerBasic> {
    int instCu(CustomerBasic customerBasic);
}
