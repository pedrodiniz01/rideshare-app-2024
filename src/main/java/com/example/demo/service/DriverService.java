package com.example.demo.service;

import com.example.demo.data.DriverJpa;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepositoryJpa;
import com.example.demo.utils.mappers.DomainToJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired
    private final DriverRepositoryJpa driverRepositoryJpa;

    public DriverService(DriverRepositoryJpa driverRepositoryJpa) {
        this.driverRepositoryJpa = driverRepositoryJpa;
    }

    public void save(Driver driver) {
        DriverJpa driverJpa = DomainToJpaMapper.toDriverJPA(driver);
        driverRepositoryJpa.save(driverJpa);
    }
}
