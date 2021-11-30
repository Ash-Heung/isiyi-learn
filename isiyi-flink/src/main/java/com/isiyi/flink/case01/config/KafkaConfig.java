package com.isiyi.flink.case01.config;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: KafkaConfig
 * @author: 向鹏飞
 * @since: 2021/6/27
 */
public class KafkaConfig {

    public final static String KAFKA_SERVER = "localhost:9092";

    public final static String KAFKA_TOPIC_GROUP = "test-flow-group";
    public final static String KAFKA_TOPIC = "test-flow-with-flink-kafka-es";

    public final static String KAFKA_KEY_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";

    public final static String KAFKA_VALUE_SERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";

}
