package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverLocation {
    private Long driverId;
    private double latitude;
    private double longitude;

    public DriverLocation(Long driverId, double latitude, double longitude) {
        this.driverId = driverId;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
