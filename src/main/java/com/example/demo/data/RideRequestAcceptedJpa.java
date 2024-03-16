package com.example.demo.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="RideRequestAccepted")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RideRequestAcceptedJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
}
