package com.example.kafka.publisher;

import com.example.test.events.TestRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Component
public class MyKafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MyKafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTestEvent() {
        TestRecord testRecord = new TestRecord();
        testRecord.setField1("1");
        testRecord.setField2("2");
        testRecord.setField3("3");
        testRecord.setField4("4");
        testRecord.setField5("5");
        testRecord.setField6("6");
        testRecord.setField7("7");
        testRecord.setField8("8");
        testRecord.setField9("9");
        try {
            final SendResult<String, Object> result = kafkaTemplate.send("test_topic", UUID.randomUUID().toString(), testRecord).get();
            System.out.println("result.toString() = " + result.toString());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
