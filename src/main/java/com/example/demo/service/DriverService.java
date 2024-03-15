package com.example.demo.service;

import com.example.demo.data.DriverJpa;
import com.example.demo.data.DriverLocationJpa;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverLocationRepositoryJpa;
import com.example.demo.repository.UserDriverRepositoryJpa;
import com.example.demo.utils.mappers.DomainToJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    private final UserDriverRepositoryJpa userDriverRepositoryJpa;

    @Autowired
    private final DriverLocationRepositoryJpa driverLocationRepositoryJpa;

    public DriverService(UserDriverRepositoryJpa userDriverRepositoryJpa, DriverLocationRepositoryJpa driverLocationRepositoryJpa) {
        this.userDriverRepositoryJpa = userDriverRepositoryJpa;
        this.driverLocationRepositoryJpa = driverLocationRepositoryJpa;
    }

    public void registerUserDriver(Driver driver) {
        DriverJpa driverJpa = DomainToJpaMapper.toDriverJPA(driver);
        userDriverRepositoryJpa.save(driverJpa);
    }

    public void updateDriverLocation(Long id, DriverLocationJpa driverLocationJpa) {
        Optional<DriverLocationJpa> optionalDriverLocation = driverLocationRepositoryJpa.findById(id);

        if (optionalDriverLocation.isPresent()) {
            DriverLocationJpa existingDriverLocation = optionalDriverLocation.get();
            existingDriverLocation.setLatitude(driverLocationJpa.getLatitude());
            existingDriverLocation.setLongitude(driverLocationJpa.getLongitude());

            driverLocationRepositoryJpa.save(existingDriverLocation);
        } else {
            DriverLocationJpa newDriverLocationJpa = new DriverLocationJpa(id, driverLocationJpa.getLatitude(), driverLocationJpa.getLongitude());
            driverLocationRepositoryJpa.save(newDriverLocationJpa);
        }
    }

    public Driver getDriverById(Long id) {
        Optional<DriverJpa> driverJpa = userDriverRepositoryJpa.findById(id);
        return driverJpa.map(DomainToJpaMapper::toDriver).orElse(null);
    }
}
