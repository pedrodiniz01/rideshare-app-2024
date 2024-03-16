package com.example.demo.kafka;

import com.example.demo.data.RideRequestAcceptedJpa;
import com.example.demo.repository.RideRequestAcceptedRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private RideRequestAcceptedRepositoryJpa rideRequestAcceptedRepositoryJpa;

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

        // Save in database
        RideRequestAcceptedJpa rideRequestAcceptedJpa = new RideRequestAcceptedJpa(null, message);
        rideRequestAcceptedRepositoryJpa.save(rideRequestAcceptedJpa);
    }

}
