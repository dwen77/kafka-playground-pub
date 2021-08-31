package com.example.kafka.consumer;

import com.example.test.events.TestRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyKafkaConsumer {

    @KafkaListener(topics = "test_topic", groupId = "my-kafka-playground1")
    public void listenGroupFoo(@Payload TestRecord message) {
        log.info("Received Message in group my-kafka-playground: " + message.toString());
    }
}
