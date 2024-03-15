package com.example.demo.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Riders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RiderJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
