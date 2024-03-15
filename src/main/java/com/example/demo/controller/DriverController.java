package com.example.demo.controller;

import com.example.demo.data.DriverLocationJpa;
import com.example.demo.dtos.LocationRequestDto;
import com.example.demo.model.DriverLocation;
import com.example.demo.service.DriverService;
import com.example.demo.utils.mappers.DomainToJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private DriverService driverService;

    @PostMapping("/drivers/{id}/location")
    public ResponseEntity<String> updateDriverLocation(@PathVariable Long id, @RequestBody LocationRequestDto locationRequest) {

        if (driverService.getDriverById(id) != null) {
            // Update database
            DriverLocationJpa driverLocationJpa =
                    DomainToJpaMapper.toDriverLocationJpa(new DriverLocation(id, locationRequest.getLatitude(), locationRequest.getLongitude()));
            driverService.updateDriverLocation(id, driverLocationJpa);

            // Publish the driver location update event to Kafka topic
            String topic = "driver-location-updates";
            String message = String.format("%s,%f,%f", id, locationRequest.getLatitude(), locationRequest.getLongitude());
            kafkaTemplate.send(topic, message);

            return ResponseEntity.ok("Driver location updated.");
        }
        else {
            return ResponseEntity.badRequest().body("Error updating driver Location.");
        }

    }
}
