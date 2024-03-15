package com.example.demo.repository;

import com.example.demo.data.RiderJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepositoryJpa extends JpaRepository<RiderJpa, Long> {
}
