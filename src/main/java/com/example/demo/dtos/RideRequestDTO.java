package com.example.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideRequestDTO {
    private final Long riderId;
    private double latitudePickUp;
    private double longitudePickUp;
    private double latitudeDropOff;
    private double longitudeDropOff;

    public RideRequestDTO(Long riderId, double latitudePickUp, double longitudePickUp, double latitudeDropOff, double longitudeDropOff) {
        this.riderId = riderId;
        this.latitudePickUp = latitudePickUp;
        this.longitudePickUp = longitudePickUp;
        this.latitudeDropOff = latitudeDropOff;
        this.longitudeDropOff = longitudeDropOff;
    }
}
