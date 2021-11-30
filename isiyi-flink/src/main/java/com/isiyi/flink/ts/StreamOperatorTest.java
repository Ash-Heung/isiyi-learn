package com.isiyi.flink.ts;

import com.isiyi.flink.dsr.CustomNonParallelSourceFunction;
import com.isiyi.flink.dsr.CustomParallelSourceFunction;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: StreamOperatorTest
 * @author: 向鹏飞
 * @since: 2021/6/21
 */
public class StreamOperatorTest {

    public static void filterFunction(StreamExecutionEnvironment environment){
        //DataStreamSource<Long> streamSource = environment.addSource(new CustomNonParallelSourceFunction());
        DataStreamSource<Long> streamSource = environment.addSource(new CustomParallelSourceFunction());
        streamSource.map(new MapFunction<Long, Long>() {
            @Override
            public Long map(Long value) throws Exception {
                return value;
            }
        }).filter(new FilterFunction<Long>() {
            @Override
            public boolean filter(Long value) throws Exception {
                return value % 2 == 0;
            }
        })
                .print()
                .setParallelism(1);
    }


    public static void unionFunction(StreamExecutionEnvironment environment){
        DataStreamSource<Long> streamSource1 = environment.addSource(new CustomNonParallelSourceFunction());
        DataStreamSource<Long> streamSource2 = environment.addSource(new CustomNonParallelSourceFunction());
        DataStream<Long> union = streamSource1.union(streamSource2);
        union.print().setParallelism(1);

    }

    public static void splitFunction(StreamExecutionEnvironment environment){
        DataStreamSource<Long> streamSource1 = environment.addSource(new CustomNonParallelSourceFunction());
        DataStreamSource<Long> streamSource2 = environment.addSource(new CustomNonParallelSourceFunction());
        DataStream<Long> union = streamSource1.union(streamSource2);
        union.print().setParallelism(1);

    }

}
