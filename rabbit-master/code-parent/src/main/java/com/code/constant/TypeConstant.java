package com.code.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zezhong.shang on 17-6-2.
 */
public class TypeConstant {
    /***
     * ����ת����Map
     */
    private static Map<String, String> typeMap = new HashMap<String, String>();

    static {
        typeMap.put("BIGINT", "Long");
        typeMap.put("INT", "Integer");
        typeMap.put("VARCHAR", "String");
        typeMap.put("TEXT", "String");
        typeMap.put("DATETIME", "Date");
        typeMap.put("DATE", "Date");
        typeMap.put("DOUBLE", "Double");
        typeMap.put("DECIMAL", "BigDecimal");
    }

    public static void addType(String columnType, String javaType) {
        typeMap.put(columnType, javaType);
    }

    public static String getJavaType(String columnType) {
        return typeMap.get(columnType);
    }
}
