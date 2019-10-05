package dxt.wj.customer.models.po;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息表
 * */
@Data
@TableName("customer_basic")
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

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;

    @TableField("create_time")
    private Date createTime;

    /**
     * 登陆状态  0 未登录  1 以登录
     * */
    @TableField("login_status")
    private String loginStatus;

    /**
     * 有效  0 无效 1 有效
     * */
    @TableField("flag")
    private String flag;

    @TableField("user_pic")
    private String userPic;



    @Override
    protected Serializable pkVal() {
        return this.customerId;
    }
}
