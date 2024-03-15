package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
public abstract class User {
    private final String name;
    private final String email;
    private final UserType userType;

    public User (String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = UserType.valueOf(userType.toString().toUpperCase(Locale.ROOT));
    }
}
