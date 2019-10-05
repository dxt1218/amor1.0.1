package helper;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应帮助类
 * */
@Data
@AllArgsConstructor //所有属性 构造方法
public class ResHelper {

    private String resCode;//状态码

    private String msg; //描述

    public static  ResHelper success( String resCode ,String msg){
        return  new ResHelper(resCode,msg);
    }

    public static  ResHelper success( String resCode){
        return  new ResHelper(resCode,"");
    }
}
