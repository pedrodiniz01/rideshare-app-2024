package com.example.demo.controller;

import com.example.demo.data.DriverLocationJpa;
import com.example.demo.data.RiderRequestJpa;
import com.example.demo.dtos.RideRequestDTO;
import com.example.demo.model.DriverLocation;
import com.example.demo.model.RiderRequest;
import com.example.demo.service.DriverService;
import com.example.demo.service.RiderService;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rides")
public class RiderController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RiderService riderService;

    @PostMapping("/request")
    public ResponseEntity<String> requestRide(@RequestBody RideRequestDTO rideRequest) {
        if (riderService.getDriverById(rideRequest.getRiderId()) != null) {
            // Update database
            RiderRequestJpa rideRequestJpa =
                    Mapper.toRiderRequestJpa(new RiderRequest(rideRequest.getRiderId(), rideRequest.getLatitudePickUp(), rideRequest.getLongitudePickUp(),
                            rideRequest.getLatitudeDropOff(), rideRequest.getLongitudeDropOff()));
            riderService.createRiderRequest(rideRequestJpa);

            // Publish the driver location update event to Kafka topic
            String topic = "ride-request-topic";
            String message = String.format("User %s is at location %.6f,%.6f and destination is at %.6f,%.6f",
                    rideRequest.getRiderId(),
                    rideRequest.getLatitudePickUp(), rideRequest.getLongitudePickUp(),
                    rideRequest.getLatitudeDropOff(), rideRequest.getLongitudeDropOff());

            kafkaTemplate.send(topic, message);

            return ResponseEntity.ok("Rider Request Created.");
        }
        else {
            return ResponseEntity.badRequest().body("Error creating Rider Request.");
        }
    }
}
