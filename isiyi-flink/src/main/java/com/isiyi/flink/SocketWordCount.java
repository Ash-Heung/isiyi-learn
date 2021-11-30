package com.isiyi.flink;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
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
        DataStreamSource<String> streamSource = environment.socketTextStream("localhost", 6666);

        // 算子操作
        SingleOutputStreamOperator<String> streamOperator = streamSource.flatMap((String input, Collector<String> out) -> {
            Arrays.stream(input.split(" ")).forEach(s -> out.collect(s));
        }).returns(Types.STRING);
        //打印
        streamOperator.print();

        // 执行
        environment.execute(">>>>>>>>>>>>>>>>>>>>>>>>>start exec>>>>>>>>>>>>>>>>>>>>>>>>>");

    }
}
