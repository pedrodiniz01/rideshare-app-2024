package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "driver-location-updates", groupId = "group")
    public void listen(String message) {
        System.out.println("Received Message in group 'my-group': " + message);
    }

}
