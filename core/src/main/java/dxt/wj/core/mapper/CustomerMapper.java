package dxt.wj.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dxt.wj.core.models.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper  extends BaseMapper<Customer> {
}
