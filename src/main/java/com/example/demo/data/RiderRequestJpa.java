package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="RidersLocation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RiderRequestJpa {
    @Id
    private Long RiderId;
    private double latitudePickUp;
    private double longitudePickUp;
    private double latitudeDropOff;
    private double longitudeDropOff;
}
