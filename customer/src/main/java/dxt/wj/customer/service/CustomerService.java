package dxt.wj.customer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import dxt.wj.customer.models.dto.ParamList;
import dxt.wj.customer.models.po.CustomerBasic;

import java.util.List;
import java.util.Map;

public interface CustomerService extends IService<CustomerBasic> {
    int instCu(CustomerBasic customerBasic);

    int insetBatchCust(List<CustomerBasic> List);
}
