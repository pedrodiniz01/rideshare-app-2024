package com.example.demo.service;

import com.example.demo.data.DriverJpa;
import com.example.demo.data.RiderJpa;
import com.example.demo.model.Driver;
import com.example.demo.model.Rider;
import com.example.demo.repository.DriverRepositoryJpa;
import com.example.demo.repository.RiderRepositoryJpa;
import com.example.demo.utils.mappers.DomainToJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService {

    @Autowired
    private final RiderRepositoryJpa riderRepositoryJpa;

    public RiderService(RiderRepositoryJpa riderRepositoryJpa) {
        this.riderRepositoryJpa = riderRepositoryJpa;
    }

    public void registerRider(Rider rider) {
        RiderJpa riderJpa = DomainToJpaMapper.toRiderJpa(rider);
        riderRepositoryJpa.save(riderJpa);
    }
}
