package com.example.demo.controller;

import com.example.demo.dtos.UserRequestDto;
import com.example.demo.model.Driver;
import com.example.demo.model.Rider;
import com.example.demo.model.UserType;
import com.example.demo.service.DriverService;
import com.example.demo.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.utils.Constants.DRIVER_USER_TYPE;
import static com.example.demo.utils.Constants.RIDER_USER_TYPE;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private DriverService driverService;
    @Autowired
    private RiderService riverService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRequestDto requestDto) {

        // Simple Validation
        if (requestDto == null || requestDto.getUserType() == null) {
            return ResponseEntity.badRequest().body("Invalid registration request.");
        }

        // Determine user type
        if (requestDto.getUserType().equalsIgnoreCase(RIDER_USER_TYPE)) {
            Rider rider = new Rider(requestDto.getName(), requestDto.getEmail(), UserType.RIDER);
            riverService.registerUserRider(rider);
        } else if (requestDto.getUserType().equalsIgnoreCase(DRIVER_USER_TYPE)) {
            Driver driver = new Driver(requestDto.getName(), requestDto.getEmail(),UserType.DRIVER);
            driverService.registerUserDriver(driver);
        } else {
            return ResponseEntity.badRequest().body("Invalid user type.");
        }

        return ResponseEntity.ok("User registered successfully.");
    }
}
