package com.example.demo.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="DriversLocation")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DriverLocationJpa {
    @Id
    private Long driverId;
    private double latitude;
    private double longitude;
}
