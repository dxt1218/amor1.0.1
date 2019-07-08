package dxt.wj.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dxt.wj.core.models.CustomerBasic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会员mapper
 * */
@Mapper
public interface CustomerMapper  extends BaseMapper<CustomerBasic> {
    int instCu(@Param("cu") CustomerBasic customerBasic);
}
