package com.isiyi.kafka.interceptor;

import com.isiyi.kafka.constants.KafkaConstantConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 拦截器测试
 * <p></p>
 * 实现一个简单的双interceptor组成的拦截链。
 *  第一个interceptor会在消息发送前将时间戳信息加到消息value的最前部；
 *  第二个interceptor会在消息发送后更新成功发送消息数或失败发送消息数
 * @version 1.0.0
 * @description: InterceptorTest
 * @author: 向鹏飞
 * @since: 2021/12/9
 */
public class InterceptorTest {

    public static void main(String[] args) throws Exception {
        // 1 设置配置信息
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConstantConfig.KAFKA_SERVER);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 2 构建拦截链
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.isiyi.kafka.interceptor.TimeInterceptor");
        interceptors.add("com.isiyi.kafka.interceptor.CountInterceptor");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);


        Producer<String, String> producer = new KafkaProducer<>(props);

        // 3 发送消息
        for (int i = 0; i < 10; i++) {

            ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConstantConfig.TEST_TOPIC, "message" + i);
            producer.send(record);
        }

        // 4 一定要关闭producer，这样才会调用interceptor的close方法
        producer.close();
    }


}
