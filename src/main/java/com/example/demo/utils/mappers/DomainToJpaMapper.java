package com.example.demo.utils.mappers;

import com.example.demo.data.DriverJpa;
import com.example.demo.model.Driver;

public class DomainToJpaMapper {
    public static DriverJpa toDriverJPA(Driver driver) {
        return new DriverJpa(null ,driver.getName(), driver.getEmail());
    }
}
