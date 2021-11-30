package com.isiyi.flink.ts;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.MapPartitionFunction;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.runtime.operators.sort.Sorter;
import org.apache.flink.util.Collector;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * 算子测试
 * <p></p>
 *
 * @version 1.0.0
 * @description: MapTest
 * @author: 向鹏飞
 * @since: 2021/6/20
 */
public class TsOperatorTest {

    /***
     * map算子
     * @param environment
     * @throws Exception
     */
    public static void  mapFunction(ExecutionEnvironment environment) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        DataSource<Integer> dataSource = environment.fromCollection(list);
        dataSource.map(i -> i + 1 ).print();
        //dataSource.map((i) -> i + 1 ).print(); 等价与下面的代码
//        dataSource.map(new MapFunction<Integer, Object>() {
//            @Override
//            public Object map(Integer integer) throws Exception {
//                return integer + 1;
//            }
//        });
    }

    /***
     * filter
     * @param environment
     * @throws Exception
     */
    public static void  filterFunction(ExecutionEnvironment environment) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        DataSource<Integer> dataSource = environment.fromCollection(list);
//        dataSource.map(i -> i + 1 ).filter(new FilterFunction<Integer>() {
//            @Override
//            public boolean filter(Integer integer) throws Exception {
//                return integer > 5 ;
//            }
//        }).print();
        dataSource.map(i -> i + 1 ).filter(i -> i > 5).print();

    }


    /***
     * map算子
     * @param environment
     * @throws Exception
     */
    public static void  mapPartitionFunction(ExecutionEnvironment environment) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            list.add("student:"+ i);
        }
        DataSource<String> dataSource = environment.fromCollection(list);
        dataSource.mapPartition(new MapPartitionFunction<String, String>() {

            @Override
            public void mapPartition(Iterable<String> iterable, Collector<String> collector) throws Exception {

            }
        });
    }

    /***
     * map算子
     * @param environment
     * @throws Exception
     */
    public static void  firstFunction(ExecutionEnvironment environment) throws Exception {
        List<Tuple2<Integer, String>> list = new ArrayList<Tuple2<Integer, String>>();
        for (int i = 10; i > 0; i--) {
            int i1 = i % 6;
            list.add(new Tuple2(i1, "student::"+i));
        }
        DataSource<Tuple2<Integer, String>> dataSource = environment.fromCollection(list);
        dataSource.print();
        System.out.println("----------------------------------------");
        dataSource.first(2).print();
        System.out.println("----------------------------------------");
        dataSource.groupBy(1).first(2).print();
        System.out.println("----------------------------------------");
        dataSource.groupBy(0).sortGroup(1, Order.ASCENDING).first(2).print();
    }

}
