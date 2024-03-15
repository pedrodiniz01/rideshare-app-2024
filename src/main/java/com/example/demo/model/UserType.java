package com.example.demo.model;

public enum UserType {
    RIDER,
    DRIVER;

    public static UserType fromString(String userTypeString) {
        for (UserType userType : UserType.values()) {
            if (userType.name().equalsIgnoreCase(userTypeString)) {
                return userType;
            }
        }
        throw new IllegalArgumentException("Invalid UserType: " + userTypeString);
    }

}
