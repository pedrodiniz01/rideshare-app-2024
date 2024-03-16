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
    public void notifyRideRequest(String message) {
        System.out.println("New Ride Request: " + message);
    }

    @KafkaListener(topics = "ride-request-acceptance-topic", groupId = "group")
    public void notifyRideRequestAcceptance(String message) {
        System.out.println("New Ride Request Accepted: " + message);
    }

}
