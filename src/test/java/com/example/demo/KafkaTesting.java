package com.example.demo;

import com.example.demo.kafka.KafkaConsumer;
import com.example.demo.repository.RideRequestAcceptedRepositoryJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaTesting {
    @Mock
    private RideRequestAcceptedRepositoryJpa rideRequestAcceptedRepositoryJpa;

    @InjectMocks
    private KafkaConsumer kafkaConsumer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testNotifyRideRequestAcceptance() {
        String message = "New Ride Request Accepted: Driver ID 1 will pick up Rider ID 1";

        kafkaConsumer.notifyRideRequestAcceptance(message);

        verify(rideRequestAcceptedRepositoryJpa).save(any());
    }
}
