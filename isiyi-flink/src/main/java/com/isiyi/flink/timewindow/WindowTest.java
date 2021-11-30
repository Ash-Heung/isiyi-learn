package com.isiyi.flink.timewindow;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: WindowTest
 * @author: 向鹏飞
 * @since: 2021/6/26
 */
public class WindowTest {

    public static void main(String[] args) throws Exception{

        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStreamSource<String> socketTextStream = executionEnvironment.socketTextStream("localhost", 9999);




        executionEnvironment.execute("WindowTest");



    }

}
