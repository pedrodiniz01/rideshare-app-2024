package com.example.demo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "driver-location-updates-topic", groupId = "group")
    public void listenDriverLocationUpdates(String message) {
        System.out.println("Driver Location Updates: " + message);
    }
    @KafkaListener(topics = "ride-request-topic", groupId = "group")
    public void listenRideRequest(String message) {
        System.out.println("Rider Request: " + message);
    }

}
