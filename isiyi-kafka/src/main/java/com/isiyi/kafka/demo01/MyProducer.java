package com.isiyi.kafka.demo01;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: MyProducer
 * @author: 向鹏飞
 * @since: 2021/7/24
 */
public class MyProducer {

    public final static String TOPIC = "topic-word-count";

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        //指定broker
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<String, String>(TOPIC, "message" + i), (metadata, exception) -> {
               // metadata.
            });
            TimeUnit.SECONDS.sleep(5);
        }

        producer.close();
    }

}
