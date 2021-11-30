package com.isiyi.flink.dsr;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.Test;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: DataStreamTest
 * @author: 向鹏飞
 * @since: 2021/6/21
 */
public class DataStreamTest {

    @Test
    public void main()  throws Exception{
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        //streamFunction(environment);
        //nonParallelSourceFunctionTest(environment);
        parallelSourceFunctionTest(environment);
        environment.execute("DataStreamTest") ;
    }

    public static void nonParallelSourceFunctionTest(StreamExecutionEnvironment environment){
        /***
         * .setParallelism(2); 会报错
         * Source: 1 is not a parallel source
         */
        DataStreamSource<Long> longDataStreamSource = environment.addSource(new CustomNonParallelSourceFunction()).setParallelism(2);
        longDataStreamSource.print().setParallelism(1);
    }

    public static void parallelSourceFunctionTest(StreamExecutionEnvironment environment){
        DataStreamSource<Long> longDataStreamSource = environment.addSource(new CustomParallelSourceFunction()).setParallelism(3);
        longDataStreamSource.print();
    }



    public static void streamFunction(StreamExecutionEnvironment environment){
        DataStreamSource<String> streamSource = environment.socketTextStream("", 9999);
        streamSource.print().setParallelism(1);
    }
}
