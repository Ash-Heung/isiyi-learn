package com.isiyi.algorithm.sorts;

import com.isiyi.algorithm.utils.SortUtil;

import java.util.Objects;

/**
 * 插入排序
 * <p></p>
 *
 * @version 1.0.0
 * @description: InsertionSort01
 * @author: 向鹏飞
 * @since: 2021/12/11
 */
public class InsertionSort01 {

    public static void sort(int[] args){
        SortUtil.print(args);
        if(Objects.isNull(args) || args.length < 2){
            return;
        }
        int length = args.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j>=0 && args[j] > args[j+1]; j--){
                SortUtil.swap(args, j, j+1 );
            }
        }
        SortUtil.print(args);

    }

}
