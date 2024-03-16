package com.example.demo.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="RidersRequest")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RiderRequestJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rideId;
    private Long riderId;
    private double latitudePickUp;
    private double longitudePickUp;
    private double latitudeDropOff;
    private double longitudeDropOff;
}
