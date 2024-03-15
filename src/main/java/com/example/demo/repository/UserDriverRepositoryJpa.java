package com.example.demo.repository;

import com.example.demo.data.DriverJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDriverRepositoryJpa extends JpaRepository<DriverJpa, Long> {
}
