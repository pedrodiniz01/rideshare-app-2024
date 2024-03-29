package com.example.demo;

import com.example.demo.data.DriverLocationJpa;
import com.example.demo.model.RiderRequest;
import com.example.demo.repository.DriverLocationRepositoryJpa;
import com.example.demo.service.DriverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class MatchingAlgorithmTesting {
    @Mock
    private DriverLocationRepositoryJpa driverLocationRepositoryJpa;

    @Test
    void testFindNearestDriverId() {
        // Mocking behaviour
        List<DriverLocationJpa> driverLocations = new ArrayList<>();
        driverLocations.add(new DriverLocationJpa(1L, 37.7749, -122.4194));
        driverLocations.add(new DriverLocationJpa(2L, 500, 500));

        Mockito.when(driverLocationRepositoryJpa.findAll()).thenReturn(driverLocations);

        // Creating DriverService instance
        DriverService driverService = new DriverService(null, driverLocationRepositoryJpa);

        // Creating rider request
        RiderRequest riderRequest = new RiderRequest(1L, 35, -120, 0.0, 0.0);

        // Testing method
        Long nearestDriverId = driverService.findNearestDriverId(riderRequest);

        // Assert
        assertEquals(1L, nearestDriverId);
    }
}
