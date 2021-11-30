package com.isiyi.flink.case01.producer;

import com.isiyi.flink.case01.config.KafkaConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;


/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: LogProducer
 * @author: 向鹏飞
 * @since: 2021/6/27
 */
public class LogProducer {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        // Kafka服务端的主机名和端口号
        properties.put("bootstrap.servers", KafkaConfig.KAFKA_SERVER);
        // key序列化
        properties.put("key.serializer", KafkaConfig.KAFKA_KEY_SERIALIZER);
        // value序列化
        properties.put("value.serializer", KafkaConfig.KAFKA_VALUE_SERIALIZER);

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);


        while (true) {
            StringBuilder builder = new StringBuilder();
            builder.append("imooc").append("\t")
                    .append("CN").append("\t")
                    .append(genLevel()).append("\t")
                    .append(LocalDateTime.now()).append("\t")
                    .append(getIp()).append("\t")
                    .append("www.gtmsh.com").append("\t")
                    .append(getTraffic()).append("\t");

            kafkaProducer.send(new ProducerRecord<>(KafkaConfig.KAFKA_TOPIC, builder.toString()));
            Thread.sleep(5000);
        }
    }

    public static String genLevel(){
        String[] levels = new String[]{"M", "E"};
        return levels[new Random().nextInt(levels.length)];
    }

    public static String getIp(){
        StringBuilder builder = new StringBuilder();
        builder.append(new Random().nextInt(256)).append(".")
                .append(new Random().nextInt(256)).append(".")
                .append(new Random().nextInt(256)).append(".")
                .append(new Random().nextInt(256));
        return builder.toString();
    }

    public static long getTraffic(){
        return  new Random().nextInt(10000);
    }
}
