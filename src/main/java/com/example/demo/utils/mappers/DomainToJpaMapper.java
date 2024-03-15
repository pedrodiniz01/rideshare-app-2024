package com.example.demo.utils.mappers;

import com.example.demo.data.DriverJpa;
import com.example.demo.data.DriverLocationJpa;
import com.example.demo.data.RiderJpa;
import com.example.demo.model.Driver;
import com.example.demo.model.DriverLocation;
import com.example.demo.model.Rider;
import com.example.demo.model.UserType;

public class DomainToJpaMapper {
    public static DriverJpa toDriverJPA(Driver driver) {
        return new DriverJpa(null ,driver.getName(), driver.getEmail());
    }

    public static Driver toDriver(DriverJpa driverJpa) {
        return new Driver(driverJpa.getName(), driverJpa.getEmail(), UserType.DRIVER);
    }

    public static RiderJpa toRiderJpa(Rider rider) {
        return new RiderJpa(null ,rider.getName(), rider.getEmail());
    }

    public static DriverLocationJpa toDriverLocationJpa(DriverLocation driverLocation) {
        return new DriverLocationJpa(driverLocation.getDriverId(), driverLocation.getLatitude(), driverLocation.getLongitude());
    }
}
