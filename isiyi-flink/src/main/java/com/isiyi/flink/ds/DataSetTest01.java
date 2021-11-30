package com.isiyi.flink.ds;

import org.apache.flink.api.java.ExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: DataSetTest01
 * @author: 向鹏飞
 * @since: 2021/6/20
 */
public class DataSetTest01 {

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment executionEnvironment = ExecutionEnvironment.getExecutionEnvironment();
        //集合结果集
        //fromCollection(executionEnvironment);
        //文件结果集
        fromFile(executionEnvironment);
    }

    /**
     * 源数据来自集合
     */
    public static void fromCollection(ExecutionEnvironment executionEnvironment) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        executionEnvironment.fromCollection(list).print();
    }

    /**
     * 源数据来自文件
     */
    public static void fromFile(ExecutionEnvironment executionEnvironment) throws Exception {
        //读取单个文件
        String input_wc = "E:\\appdata\\wordcount.txt";
        executionEnvironment.readTextFile(input_wc).print();
        //读取文件夹
        System.out.println("*********************************************");
        String input_dir = "E:\\appdata\\input";
        executionEnvironment.readTextFile(input_dir).print();
    }
}
