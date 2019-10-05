package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 对象转换 objectMapper
 */
@Slf4j
public class ObjJsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转json
     */
    public static String objToJson(Object obj) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("object转换异常");
        }
        return null;
    }
    /**
     * json转对象
     */
    public static Object jsonToObj(String objJson, Class targetObj) {
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(objJson, targetObj);
        } catch (IOException e) {
            log.error("json转换Object异常");
        }
        return null;
    }
    /**
     * 对象转对象
     */
    public static Object objToObj(Object obj,Object targetObj){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            String json= objectMapper.writeValueAsString(obj);
            Class clazz  = targetObj.getClass();
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("object转换异常");
        } catch (IOException e) {
            log.error("json转换Object异常");
        }
        return  null;
    }


    /**
     * 对象转对象
     */
    public static Object objToObj(Object obj,Class targetObj){
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            String json= objectMapper.writeValueAsString(obj);
            return objectMapper.readValue(json, targetObj);
        } catch (JsonProcessingException e) {
            log.error("object转换异常");
        } catch (IOException e) {
            log.error("json转换Object异常");
        }
        return  null;
    }
}
