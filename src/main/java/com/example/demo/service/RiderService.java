package com.example.demo.service;

import com.example.demo.data.RiderJpa;
import com.example.demo.model.Rider;
import com.example.demo.repository.UserRiderRepositoryJpa;
import com.example.demo.utils.mappers.DomainToJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService {

    @Autowired
    private final UserRiderRepositoryJpa userRiderRepositoryJpa;

    public RiderService(UserRiderRepositoryJpa userRiderRepositoryJpa) {
        this.userRiderRepositoryJpa = userRiderRepositoryJpa;
    }

    public void registerUserRider(Rider rider) {
        RiderJpa riderJpa = DomainToJpaMapper.toRiderJpa(rider);
        userRiderRepositoryJpa.save(riderJpa);
    }
}
