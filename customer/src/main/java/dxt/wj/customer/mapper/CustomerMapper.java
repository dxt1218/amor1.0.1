package dxt.wj.customer.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dxt.wj.customer.models.dto.ParamList;
import dxt.wj.customer.models.po.CustomerBasic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 会员mapper
 * */
@Mapper
public interface CustomerMapper extends BaseMapper<CustomerBasic> {
    int instCu(@Param("cu") CustomerBasic customerBasic);

   // int insertBatchCustomer(@Param("ParamList") List<ParamList> list);
    int insertBatchCustomer(List<CustomerBasic> list);
}
