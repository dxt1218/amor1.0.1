package dxt.wj.core.models;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息表
 * */
@Data
@TableName("Customer_basic")
public class CustomerBasic extends Model<CustomerBasic> {

    @TableId(value = "customer_id",type = IdType.UUID)
    private String customerId;

    @TableField("login_name")
    private String loginName;

    @TableField("real_name")
    private String realName;

    @TableField("password")
    private String password;

    @TableField("sex")
    private String sex;

    @TableField("create_time")
    private Date createTime;

    @TableField("login_status")
    private String loginStatus;

    @TableField("flag")
    private String flag;


    @Override
    protected Serializable pkVal() {
        return this.customerId;
    }
}
