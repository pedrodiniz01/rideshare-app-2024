package com.example.demo.service;

import com.example.demo.data.DriverJpa;
import com.example.demo.data.DriverLocationJpa;
import com.example.demo.data.RiderJpa;
import com.example.demo.data.RiderRequestJpa;
import com.example.demo.model.Driver;
import com.example.demo.model.Rider;
import com.example.demo.model.RiderRequest;
import com.example.demo.repository.RiderLocationRepositoryJpa;
import com.example.demo.repository.UserRiderRepositoryJpa;
import com.example.demo.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RiderService {

    @Autowired
    private final UserRiderRepositoryJpa userRiderRepositoryJpa;

    @Autowired
    private final RiderLocationRepositoryJpa riderLocationRepositoryJpa;

    public RiderService(UserRiderRepositoryJpa userRiderRepositoryJpa, RiderLocationRepositoryJpa riderLocationRepositoryJpa) {
        this.userRiderRepositoryJpa = userRiderRepositoryJpa;
        this.riderLocationRepositoryJpa = riderLocationRepositoryJpa;
    }

    public void registerUserRider(Rider rider) {
        RiderJpa riderJpa = Mapper.toRiderJpa(rider);
        userRiderRepositoryJpa.save(riderJpa);
    }

    public void createRiderRequest(RiderRequestJpa riderRequestJpa) {
        Optional<RiderRequestJpa> optionalRiderRequestLocation = riderLocationRepositoryJpa.findById(riderRequestJpa.getRiderId());

        // override logic
        if (optionalRiderRequestLocation.isPresent()) {
            RiderRequestJpa existingRiderRequestLocation = optionalRiderRequestLocation.get();
            existingRiderRequestLocation.setLatitudePickUp(riderRequestJpa.getLatitudePickUp());
            existingRiderRequestLocation.setLongitudePickUp(riderRequestJpa.getLongitudePickUp());
            existingRiderRequestLocation.setLatitudeDropOff(riderRequestJpa.getLatitudeDropOff());
            existingRiderRequestLocation.setLongitudeDropOff(riderRequestJpa.getLongitudeDropOff());

            riderLocationRepositoryJpa.save(existingRiderRequestLocation);
        } else {
            RiderRequestJpa newRiderRequestJpa = new RiderRequestJpa(riderRequestJpa.getRiderId(), riderRequestJpa.getLatitudePickUp(),
                    riderRequestJpa.getLongitudePickUp(), riderRequestJpa.getLatitudeDropOff(), riderRequestJpa.getLongitudeDropOff());
            riderLocationRepositoryJpa.save(newRiderRequestJpa);
        }
    }

    public Rider getDriverById(Long id) {
        Optional<RiderJpa> riderJpa = userRiderRepositoryJpa.findById(id);
        return riderJpa.map(Mapper::toRider).orElse(null);
    }
}
