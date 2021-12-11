package com.isiyi.algorithm;

import com.isiyi.algorithm.sorts.BubbleSort01;
import com.isiyi.algorithm.sorts.InsertionSort01;
import com.isiyi.algorithm.sorts.SelectionSort01;
import com.isiyi.algorithm.utils.SortUtil;
import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: SelectionSort01Test
 * @author: 向鹏飞
 * @since: 2021/12/11
 */
public class SortTest {


    @Test
    public void testSelectionSort01(){
        int[] args = new int[]{2, 6, 1, 5, 63, 52};
        SelectionSort01.sort(args);
    }

    @Test
    public void testBubbleSort01(){
        int[] args = SortUtil.generateRandomArray(10, 47);
        BubbleSort01.sort(args);
    }


    @Test
    public void testInsertionSort01(){
        InsertionSort01.sort(SortUtil.generateRandomArray(10, 47));
    }

}
