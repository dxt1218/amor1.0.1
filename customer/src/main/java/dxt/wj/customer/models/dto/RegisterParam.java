package dxt.wj.customer.models.dto;

import lombok.Data;


/**
 * 注册登录类
 * */
@Data
public class RegisterParam  {

    private String loginName; //昵称

    private String  sex;//性别 0女 1男

    private String email;//邮箱

    private String password;//密码

    private String phone ; //手机号

}
