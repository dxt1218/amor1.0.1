package dxt.wj.customer.service.imp;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dxt.wj.customer.mapper.CustomerMapper;
import dxt.wj.customer.models.dto.ParamList;
import dxt.wj.customer.models.po.CustomerBasic;
import dxt.wj.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImp  extends ServiceImpl<CustomerMapper, CustomerBasic> implements CustomerService {
    @Resource
    CustomerMapper customerMapper;
    @Override
    public int instCu(CustomerBasic customerBasic) {
        return customerMapper.instCu(customerBasic);
    }

    @Override
    public int insetBatchCust(List<CustomerBasic> paramList) {
        return customerMapper.insertBatchCustomer(paramList);
    }

    /**
     * 获取类 注解
     * */
    public Map<String,String> getAnnotationsVules(CustomerBasic obj){
        Map<String,String> map = new LinkedHashMap<>();
        Class objClass = obj.getClass();
        Field[] fields=objClass.getDeclaredFields();
        for(Field f:fields){
            if(f.getAnnotation(TableId.class)!=null){
                map.put(f.getAnnotation(TableId.class).getClass().getName(),f.getAnnotation(TableId.class).value());
            }
            if(f.getAnnotation(TableField.class)!=null){
                map.put(f.getAnnotation(TableField.class).value(),f.getAnnotation(TableField.class).value());
            }
        }
        return map;
    }
}
