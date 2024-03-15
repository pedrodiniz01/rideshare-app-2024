package com.example.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Drivers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DriverJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
