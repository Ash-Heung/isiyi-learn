package com.isiyi.kafka.producers;

import com.isiyi.kafka.constants.KafkaConstantConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 自定义分区生产者
 * <p></p>
 *
 * @version 1.0.0
 * @description: CustomPartitionerProducer
 * @author: 向鹏飞
 * @since: 2021/12/9
 */
public class CustomPartitionerProducer {

    public static void main(String[] args) {
        Properties props = new Properties();
        // Kafka服务端的主机名和端口号
        props.put("bootstrap.servers", KafkaConstantConfig.KAFKA_SERVER);
        // 等待所有副本节点的应答
        props.put("acks", "all");
        // 消息发送最大尝试次数
        props.put("retries", 0);
        // 一批消息处理大小
        props.put("batch.size", 16384);
        // 增加服务端请求延时
        props.put("linger.ms", 1);
        // 发送缓存区内存大小
        props.put("buffer.memory", 33554432);
        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 自定义分区
        props.put("partitioner.class", "com.isiyi.kafka.partition.CustomPartitioner");

        Producer<String, String> producer = new KafkaProducer<>(props);
        producer.send(new ProducerRecord<String, String>(KafkaConstantConfig.TEST_TOPIC, "1", "CustomPartitionerProducer"));

        producer.close();



    }

}
