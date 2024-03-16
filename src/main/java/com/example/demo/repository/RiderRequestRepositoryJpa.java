package com.example.demo.repository;

import com.example.demo.data.RiderRequestJpa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RiderRequestRepositoryJpa extends JpaRepository<RiderRequestJpa, Long> {

    @Override
    Optional<RiderRequestJpa> findById(Long aLong);


}
