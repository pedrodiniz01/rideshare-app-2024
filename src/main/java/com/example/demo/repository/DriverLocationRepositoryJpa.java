package com.example.demo.repository;

import com.example.demo.data.DriverLocationJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverLocationRepositoryJpa extends JpaRepository<DriverLocationJpa, Long> {
    Optional<DriverLocationJpa> findById(Long id);

    @Override
    List<DriverLocationJpa> findAll();
}
