package com.isiyi.base.cache;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: ObjB
 * @author: 向鹏飞
 * @since: 2021/8/4
 */
public class ObjB {


    public String getCache(){
        return LocalCache.get("123");
    }

}
