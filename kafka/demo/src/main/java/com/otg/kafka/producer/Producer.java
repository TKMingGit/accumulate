package com.otg.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.Properties;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/2/5 15:31
 * @desc 暂无
 */
public class Producer {
    public static void main(String[] args) {
        //1.kafka生产者配置信息
        Properties properties = new Properties();
        //2.指定链接的Kafka集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.185.32.130:9092,10.185.32.133:9092,10.185.32.134:9092");
        //3.
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.185.32.130:9092,10.185.32.133:9092,10.185.32.134:9092");
        //3.
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.185.32.130:9092,10.185.32.133:9092,10.185.32.134:9092");
        //3.
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.185.32.130:9092,10.185.32.133:9092,10.185.32.134:9092");
        //3.
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.185.32.130:9092,10.185.32.133:9092,10.185.32.134:9092");
        //3.
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.185.32.130:9092,10.185.32.133:9092,10.185.32.134:9092");


        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
    }
}
