package com.example.kafka.publisher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class Controller {

    private final MyKafkaProducer kafkaProducer;

    public Controller(MyKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage() {
//        kafkaProducer.send();
        kafkaProducer.sendTestEvent();
        return ResponseEntity.ok("succ");
    }
}
