package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class Driver extends User{

    public Driver(String name, String email, UserType userType) {
        super(name, email, userType);
    }


}
