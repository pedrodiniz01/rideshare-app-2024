package com.example.demo.repository;

import com.example.demo.data.DriverJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDriverRepositoryJpa extends JpaRepository<DriverJpa, Long> {

    @Override
    Optional<DriverJpa> findById(Long aLong);
}
