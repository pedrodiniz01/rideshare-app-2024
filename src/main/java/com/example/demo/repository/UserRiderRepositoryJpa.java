package com.example.demo.repository;

import com.example.demo.data.RiderJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRiderRepositoryJpa extends JpaRepository<RiderJpa, Long> {
    @Override
    Optional<RiderJpa> findById(Long aLong);
}
