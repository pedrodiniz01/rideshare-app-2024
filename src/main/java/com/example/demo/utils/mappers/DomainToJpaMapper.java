package com.example.demo.utils.mappers;

import com.example.demo.data.DriverJpa;
import com.example.demo.data.RiderJpa;
import com.example.demo.model.Driver;
import com.example.demo.model.Rider;

public class DomainToJpaMapper {
    public static DriverJpa toDriverJPA(Driver driver) {
        return new DriverJpa(null ,driver.getName(), driver.getEmail());
    }

    public static RiderJpa toRiderJpa(Rider rider) {
        return new RiderJpa(null ,rider.getName(), rider.getEmail());
    }
}
