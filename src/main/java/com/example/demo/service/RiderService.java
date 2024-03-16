package com.example.demo.service;

import com.example.demo.data.RiderJpa;
import com.example.demo.data.RiderRequestJpa;
import com.example.demo.model.Rider;
import com.example.demo.model.RiderRequest;
import com.example.demo.repository.RiderRequestRepositoryJpa;
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
    private final RiderRequestRepositoryJpa riderRequestRepositoryJpa;

    public RiderService(UserRiderRepositoryJpa userRiderRepositoryJpa, RiderRequestRepositoryJpa riderRequestRepositoryJpa) {
        this.userRiderRepositoryJpa = userRiderRepositoryJpa;
        this.riderRequestRepositoryJpa = riderRequestRepositoryJpa;
    }

    public void registerUserRider(Rider rider) {
        RiderJpa riderJpa = Mapper.toRiderJpa(rider);
        userRiderRepositoryJpa.save(riderJpa);
    }

    public void createRiderRequest(RiderRequestJpa riderRequestJpa) {
        Optional<RiderJpa> optionalUserRider = userRiderRepositoryJpa.findById(riderRequestJpa.getRiderId());

        // Validate if user exists
        if (optionalUserRider.isPresent()) {
            RiderRequestJpa newRiderRequestLocation = new RiderRequestJpa();
            newRiderRequestLocation.setRiderId(riderRequestJpa.getRiderId());
            newRiderRequestLocation.setLatitudePickUp(riderRequestJpa.getLatitudePickUp());
            newRiderRequestLocation.setLongitudePickUp(riderRequestJpa.getLongitudePickUp());
            newRiderRequestLocation.setLatitudeDropOff(riderRequestJpa.getLatitudeDropOff());
            newRiderRequestLocation.setLongitudeDropOff(riderRequestJpa.getLongitudeDropOff());

            riderRequestRepositoryJpa.save(newRiderRequestLocation);
        }
    }

    public Rider getRiderById(Long id) {
        Optional<RiderJpa> riderJpa = userRiderRepositoryJpa.findById(id);
        return riderJpa.map(Mapper::toRider).orElse(null);
    }

    public RiderRequest getRideById(Long id) {
        Optional<RiderRequestJpa> riderRequestJpa = riderRequestRepositoryJpa.findById(id);
        return riderRequestJpa.map(Mapper::toRiderRequest).orElse(null);
    }

}
