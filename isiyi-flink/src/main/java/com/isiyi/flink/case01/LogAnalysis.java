package com.isiyi.flink.case01;

import com.isiyi.flink.case01.config.KafkaConfig;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer09;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumerBase;

import java.util.Properties;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: LogAnalysis
 * @author: 向鹏飞
 * @since: 2021/6/27
 */
public class LogAnalysis {

    public static void main(String[] args) throws Exception{
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties properties = new Properties();
        // Kafka服务端的主机名和端口号
        properties.put("bootstrap.servers", KafkaConfig.KAFKA_SERVER);
        properties.put("group.id", KafkaConfig.KAFKA_TOPIC_GROUP);
        FlinkKafkaConsumerBase<String> kafkaConsumer = new FlinkKafkaConsumer09<String>(KafkaConfig.KAFKA_TOPIC, new SimpleStringSchema(), properties);

        DataStreamSource<String> dataStreamSource = executionEnvironment.addSource(kafkaConsumer);

        dataStreamSource.print().setParallelism(1);

        executionEnvironment.execute("LogAnalysis.....");

    }
}
