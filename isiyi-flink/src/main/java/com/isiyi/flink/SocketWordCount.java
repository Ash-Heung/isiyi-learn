package com.isiyi.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.util.Collector;

import java.util.Arrays;

/**
 * 网络 word count
 * <p></p>
 *
 * @version 1.0.0
 * @description: SocketWordCount
 * @author: 向鹏飞
 * @since: 2021/11/30
 */
public class SocketWordCount {

    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.createLocalEnvironmentWithWebUI(new Configuration());
        DataStreamSource<String> socketSource = environment.socketTextStream("localhost", 6666);
        // 重试策略
        //environment.setRestartStrategy();

        //1.lambda写法
//        SingleOutputStreamOperator<String> flatMap = socketSource.flatMap((String value, Collector<String> out) -> {
//            Arrays.stream(value.split(" ")).forEach(word -> {
//                out.collect(word);
//            });
//        }).returns(Types.STRING);
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> map = flatMap.map(f -> Tuple2.of(f, 1)).returns(Types.TUPLE(Types.STRING, Types.INT));
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = map.keyBy(0).sum(1);
//
//        sum.print();

        //2.function写法
//        SingleOutputStreamOperator<String> flatMap = socketSource.flatMap(new FlatMapFunction<String, String>() {
//            @Override
//            public void flatMap(String value, Collector<String> out) throws Exception {
//                String[] s = value.split(" ");
//                for (String ss : s) {
//                    out.collect(ss);
//                }
//            }
//        });
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> map = flatMap.map(new MapFunction<String, Tuple2<String, Integer>>() {
//            @Override
//            public Tuple2<String, Integer> map(String value) throws Exception {
//                return Tuple2.of(value, 1);
//            }
//        });
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = map.keyBy("f0").sum(1);
//
//        sum.print();

        //3.function组合写法
//        SingleOutputStreamOperator<Tuple2<String,Integer>> flatMap = socketSource.flatMap(new FlatMapFunction<String, Tuple2<String,Integer>>() {
//            @Override
//            public void flatMap(String value, Collector<Tuple2<String,Integer>> out) throws Exception {
//                String[] s = value.split(" ");
//                for (String ss : s) {
//                    out.collect(Tuple2.of(ss,1));
//                }
//            }
//        });
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = flatMap.keyBy(f -> f.f0).sum(1);
//
//        sum.print();

        //4.richfunction组合写法
//        SingleOutputStreamOperator<Tuple2<String, Integer>> flatMap = socketSource.flatMap(new RichFlatMapFunction<String, Tuple2<String, Integer>>() {
//
//            private String name = null;
//
//            @Override
//            public void open(Configuration parameters) throws Exception {
//                name = "test_";
//            }
//
//            @Override
//            public void close() throws Exception {
//                name = null;
//            }
//
//            @Override
//            public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
//                String[] s = value.split(" ");
//                for (String ss : s) {
//                    System.out.println(getRuntimeContext().getIndexOfThisSubtask());
//                    out.collect(Tuple2.of(name + ss, 1));
//                }
//            }
//        });
//
//        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = flatMap.keyBy(new KeySelector<Tuple2<String, Integer>, String>() {
//            @Override
//            public String getKey(Tuple2<String, Integer> value) throws Exception {
//                return value.f0;
//            }
//        }).sum(1);
//
//        sum.print();


        //5.processfunction组合写法
        SingleOutputStreamOperator<Tuple2<String, Integer>> sum = socketSource.process(new ProcessFunction<String, Tuple2<String, Integer>>() {

            private String name = null;

            @Override
            public void open(Configuration parameters) throws Exception {
                name = "hainiu_";
            }

            @Override
            public void close() throws Exception {
                name = null;
            }

            @Override
            public void processElement(String value, Context ctx, Collector<Tuple2<String, Integer>> out) throws Exception {
//                getRuntimeContext()
                String[] s = value.split(" ");
                for (String ss : s) {
                    System.out.println(getRuntimeContext().getIndexOfThisSubtask());
                    out.collect(Tuple2.of(name + ss, 1));
                }
            }
        }).keyBy(0).process(new KeyedProcessFunction<Tuple, Tuple2<String, Integer>, Tuple2<String, Integer>>() {
            private Integer num = 0;

            @Override
            public void processElement(Tuple2<String, Integer> value, Context ctx, Collector<Tuple2<String, Integer>> out) throws Exception {
                num += value.f1;
                out.collect(Tuple2.of(value.f0,num));
            }
        });

        //打印
        sum.print();

        // 执行
        environment.execute(">>>>>>>>>>>>>>>>>>>>>>>>>start exec>>>>>>>>>>>>>>>>>>>>>>>>>");

    }
}
