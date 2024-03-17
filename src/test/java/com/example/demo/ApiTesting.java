package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.service.DriverService;
import com.example.demo.service.RiderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ApiTesting {

    @Mock
    private RiderService riderService;

    @Mock
    private DriverService driverService;

    @Test
    public void testRegisterUser_validUserType() {
        // Arrange
        UserRequestDto requestDto = new UserRequestDto("Pedro", "pedrodiniz@ceiia.com", "rider");
        UserController controller = new UserController(driverService, riderService);

        // Act
        ResponseEntity<String> response = controller.registerUser(requestDto);

        // Assert
        assertEquals(ResponseEntity.ok("User registered successfully."), response);
    }

    @Test
    public void testRegisterUser_invalidUserType() {
        // Arrange
        UserRequestDto requestDto = new UserRequestDto("Pedro", "pedrodiniz@ceiia.com", "whatever");
        UserController controller = new UserController(driverService, riderService);

        // Act
        ResponseEntity<String> response = controller.registerUser(requestDto);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Invalid user type."), response);
    }
}
