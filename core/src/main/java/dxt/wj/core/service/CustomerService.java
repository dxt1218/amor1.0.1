package dxt.wj.core.service;


import com.baomidou.mybatisplus.extension.service.IService;
import dxt.wj.core.models.CustomerBasic;

public interface CustomerService extends IService<CustomerBasic> {
    int instCu(CustomerBasic customerBasic);
}
