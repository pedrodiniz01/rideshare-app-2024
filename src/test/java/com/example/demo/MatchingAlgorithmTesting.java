package com.example.demo;

import com.example.demo.data.DriverLocationJpa;
import com.example.demo.model.RiderRequest;
import com.example.demo.repository.DriverLocationRepositoryJpa;
import com.example.demo.service.DriverService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class MatchingAlgorithmTesting {

    @Mock
    DriverService driverService;

    @Test
    void testFindNearestDriverId() {
        // Mocking the driverLocationRepositoryJpa
        DriverLocationRepositoryJpa driverLocationRepositoryJpa = Mockito.mock(DriverLocationRepositoryJpa.class);

        // Creating some sample driver locations
        List<DriverLocationJpa> driverLocations = new ArrayList<>();
        driverLocations.add(new DriverLocationJpa(1L, 37.7749, -122.4194));
        driverLocations.add(new DriverLocationJpa(2L, 34.0522, -118.2437));
        driverLocations.add(new DriverLocationJpa(3L, 40.7128, -74.0060));

        // Mocking the behavior of driverLocationRepositoryJpa
        Mockito.when(driverLocationRepositoryJpa.findAll()).thenReturn(driverLocations);

        // Creating a sample rider request
        RiderRequest riderRequest = new RiderRequest(1L, 37.7749, -122.4194, 0.0, 0.0);


        // Testing the method
        Long nearestDriverId = driverService.findNearestDriverId(riderRequest);

        // Asserting the result
        assertEquals(0L, nearestDriverId); // Expecting the nearest driver to be the one in San Francisco
    }
}
