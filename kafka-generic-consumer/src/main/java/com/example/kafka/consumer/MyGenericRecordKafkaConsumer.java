package com.example.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyGenericRecordKafkaConsumer {

    @KafkaListener(topics = "test_topic", groupId = "my-kafka-playground-generic")
    public void listenGroupFoo(GenericRecord message) {
        log.info("Received Message in group my-kafka-playground: " + message.toString());
    }
}
