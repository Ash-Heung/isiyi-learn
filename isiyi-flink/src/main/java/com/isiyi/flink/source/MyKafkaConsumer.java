package com.isiyi.flink.source;

import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: MyKafkaConsumer
 * @author: 向鹏飞
 * @since: 2021/12/19
 */
public class MyKafkaConsumer extends FlinkKafkaConsumer {

    public MyKafkaConsumer(String topic, DeserializationSchema valueDeserializer, Properties props) {
        super(topic, valueDeserializer, props);
    }
}
