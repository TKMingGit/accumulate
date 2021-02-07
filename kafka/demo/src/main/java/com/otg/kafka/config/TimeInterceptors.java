package com.otg.kafka.config;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/2/5 15:46
 * @desc 暂无
 */
public class TimeInterceptors<K, V> implements ProducerInterceptor<K, V> {
    @Override
    public ProducerRecord<K, V> onSend(ProducerRecord<K, V> producerRecord) {
        return null;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
