package com.hll.framework.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by hll on 2016/4/13.
 * JSON工具类
 */
public final class JsonUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  /**
   * 将POJO转为JSON
   */
  public static <T> String toJson(T obj) {
    String json;
    try {
      json = OBJECT_MAPPER.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      LOGGER.error("convert POJO to JSON failure", e);
      throw new RuntimeException(e);
    }
    return json;
  }

  /**
   * 将JSON转为POJO
   */
  public static <T> T fromJson(String json,Class<T> type){
    T pojo;
    try {
      pojo=OBJECT_MAPPER.readValue(json,type);
    } catch (Exception e) {
      LOGGER.error("convert JSON to POJO failure",e);
      throw new RuntimeException(e);
    }
    return pojo;
  }
}