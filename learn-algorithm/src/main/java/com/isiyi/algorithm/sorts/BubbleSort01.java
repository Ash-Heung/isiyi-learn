package com.isiyi.algorithm.sorts;

import com.isiyi.algorithm.utils.SortUtil;

import java.util.Objects;

/**
 * 冒泡排序
 * <p></p>
 *
 * @version 1.0.0
 * @description: SelectionSort01
 * @author: 向鹏飞
 * @since: 2021/12/11
 */
public class BubbleSort01 {

    /**
     * 0~n-1
     * 1~n-1
     * 2~n-1
     * .....
     * @param args
     */
    public static void sort(int[] args){
        if(Objects.isNull(args) || args.length<0){
            return;
        }
        SortUtil.print(args);

        for (int e = args.length-1; e > 0;  e--) {
            for (int i = 0; i < e; i ++){
                if(args[i] > args[i + 1]){
                    SortUtil.swap(args, i, i + 1);
                }
            }
        }
        SortUtil.print(args);
    }


}
