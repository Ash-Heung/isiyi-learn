package com.isiyi.algorithm.sorts;

import com.isiyi.algorithm.utils.SortUtil;

import java.util.Objects;

/**
 * 选择排序
 * <p></p>
 *
 * @version 1.0.0
 * @description: SelectionSort01
 * @author: 向鹏飞
 * @since: 2021/12/11
 */
public class SelectionSort01 {

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
        int length = args.length;
        for (int i=0; i < length; i ++){
            // 假定第一位的数最小
            int minIndex = i;
            for (int j = i+1; j < length; j++){
                // 寻找最小的，交换
                minIndex = args[j] < args[minIndex] ? j : minIndex;
            }
            // swap
            SortUtil.swap(args, i, minIndex);
        }
        SortUtil.print(args);
    }


}
