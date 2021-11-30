package com.isiyi.flink.excutor;

import com.isiyi.flink.domain.WordCountDomain;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * 实现每隔1秒对最近2S内的数据进行汇总计算
 * 单词计算之滑动窗口计算
 * <p></p>
 *
 * @version 1.0.0
 * @description: WordCountExecutor
 * @author: 向鹏飞
 * @since: 2021/6/6
 */
public class WordCountStreamExecutor {

    public static void main(String[] args) throws Exception {
        //获取关口
        int port;
        try {

            ParameterTool parameterTool = ParameterTool.fromArgs(args);
            port = parameterTool.getInt("port");
        }catch (Exception e){
            e.printStackTrace();
            port = 9000;
        }
        //获取Flink运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        String hostName = "127.0.0.1";
        String delimiter = "\n";
        //连接socket获取输入数据
        DataStreamSource<String> textStream = env.socketTextStream(hostName, port, delimiter);

        DataStream<WordCountDomain> wordCounts = textStream.flatMap(new FlatMapFunction<String, WordCountDomain>() {
            @Override
            public void flatMap(String value, Collector<WordCountDomain> collector) throws Exception {
                String[] split = value.split("\\s");
                for (String word : split) {
                    collector.collect(new WordCountDomain(word, 1L));
                }
            }
        }).keyBy("word")
        //指定时间窗口大小为2秒，指定时间间隔为1S
        .timeWindow(Time.seconds(2), Time.seconds(1))
        .reduce(new ReduceFunction<WordCountDomain>() {
            @Override
            public WordCountDomain reduce(WordCountDomain t1, WordCountDomain t2) throws Exception {
                return new WordCountDomain(t1.getWord(), t1.getCount() + t2.getCount());
            }
        });
        //sum或者reduce否可以
        //.sum("count");

        //把数据打印到控制台，并设置并行度
        wordCounts.print().setParallelism(1);
        //执行任务
        env.execute("执行。。。。");
    }


}
