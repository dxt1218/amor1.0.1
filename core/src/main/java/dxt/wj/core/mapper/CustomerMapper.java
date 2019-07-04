package dxt.wj.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import dxt.wj.core.models.CustomerBasic;
import org.apache.ibatis.annotations.Mapper;
/**
 * 会员mapper
 * */
@Mapper
public interface CustomerMapper  extends BaseMapper<CustomerBasic> {
}
