package helper;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

@Slf4j
public class ModelHelper {
    /**
     * 反射  插入初始化类
     */
    public static Object initModel(Object obj) {
        //获取 对象所有属性
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                field.setAccessible(true);
                if (field.getAnnotation(TableId.class) != null) {
                    String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                    field.set(obj,id);
                }
                if ("createTime".equals(fieldName)) {
                    field.set(obj,new Date());
                }
                if ("flag".equals(fieldName)) {
                    field.set(obj,"1");
                }
                if ("loginStatus".equals(fieldName)) {
                    field.set(obj,"0");
                }
            } catch (IllegalAccessException e) {
                log.error("反射赋值异常");
                log.info("反射赋值异常",e);
            }
        }
        return null;
    }
}
