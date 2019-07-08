package dxt.wj.customer.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dxt.wj.customer.models.CustomerBasic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会员mapper
 * */
@Mapper
public interface CustomerMapper extends BaseMapper<CustomerBasic> {
    int instCu(@Param("cu") CustomerBasic customerBasic);
}
