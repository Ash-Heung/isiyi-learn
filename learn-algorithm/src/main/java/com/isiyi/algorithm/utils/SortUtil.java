package com.isiyi.algorithm.utils;

import com.alibaba.fastjson.JSON;
import netscape.javascript.JSObject;

import java.util.Arrays;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: SortUtil
 * @author: 向鹏飞
 * @since: 2021/12/11
 */
public class SortUtil {

    /**
     * 交换
     * @param args
     * @param position
     * @param min
     */
    public static void swap(int[] args, int position, int min){
        int tmp = args[position];
        args[position] = args[min];
        args[min] = tmp;
    }

    /**
     * 打印
     * @param args
     */
    public static void print(int[] args){
        System.out.println(JSON.toJSONString(args));
    }


    /**
     * 生成随机的数据
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
