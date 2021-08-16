package com.isiyi.base.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: LocalCache
 * @author: 向鹏飞
 * @since: 2021/8/4
 */
public class LocalCache {
    private final static ConcurrentHashMap<String, String> CACHE = new ConcurrentHashMap<>();

    public static void put(String key, String value){
        CACHE.put(key, value);
    }

    public static String get(String key){
        return CACHE.get(key);
    }


}
