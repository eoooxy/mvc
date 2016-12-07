package com.test.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-12-5 0005.
 */

public class JsonUtil {

    private JsonUtil() {
        //工具类无需对象实例化
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public static String toJson(Object object, boolean isFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (isFormat) {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } else {
            return mapper.writeValueAsString(object);
        }
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return toJson(object, false);
    }

    public static <T> T toObject(String content, Class<T> c)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, c);
    }

    public static <T> List<T> toListObject(String content, Class<T> c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType t = getCollectionType(ArrayList.class, c);
        return (List<T>) mapper.readValue(content, t);
    }

    public static <T> Map<String, T> toMapObject(String content, Class<T> c) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType t = getCollectionType(HashMap.class, String.class, c);
        return (Map<String, T>) mapper.readValue(content, t);
    }
}