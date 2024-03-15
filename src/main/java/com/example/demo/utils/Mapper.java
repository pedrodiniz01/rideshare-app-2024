package com.example.demo.utils;

import com.example.demo.data.DriverJpa;
import com.example.demo.data.DriverLocationJpa;
import com.example.demo.data.RiderJpa;
import com.example.demo.data.RiderRequestJpa;
import com.example.demo.model.*;

public class Mapper {
    public static DriverJpa toDriverJPA(Driver driver) {
        return new DriverJpa(null ,driver.getName(), driver.getEmail());
    }

    public static Driver toDriver(DriverJpa driverJpa) {
        return new Driver(driverJpa.getName(), driverJpa.getEmail(), UserType.DRIVER);
    }

    public static RiderJpa toRiderJpa(Rider rider) {
        return new RiderJpa(null ,rider.getName(), rider.getEmail());
    }
    public static Rider toRider(RiderJpa riderJpa) {
        return new Rider(riderJpa.getName() ,riderJpa.getEmail(), UserType.RIDER);
    }

    public static DriverLocationJpa toDriverLocationJpa(DriverLocation driverLocation) {
        return new DriverLocationJpa(driverLocation.getDriverId(), driverLocation.getLatitude(), driverLocation.getLongitude());
    }
    public static RiderRequestJpa toRiderRequestJpa(RiderRequest riderRequest) {
        return new RiderRequestJpa(riderRequest.getRiderId(), riderRequest.getLatitudePickUp(),
                riderRequest.getLongitudePickUp(), riderRequest.getLatitudeDropOff(), riderRequest.getLatitudeDropOff());
    }
}
