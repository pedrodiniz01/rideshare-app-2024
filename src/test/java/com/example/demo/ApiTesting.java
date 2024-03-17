package com.example.demo;

import com.example.demo.controller.UserController;
import com.example.demo.dtos.UserRequestDto;
import com.example.demo.service.DriverService;
import com.example.demo.service.RiderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApiTesting {

    @Mock
    private RiderService riderService;

    @Mock
    private DriverService driverService;

    @Test
    public void testRegisterUser_validUserType() {
        // Arrange
        UserRequestDto requestDto = new UserRequestDto("John Doe", "john@example.com", "rider");
        UserController controller = new UserController(driverService, riderService);

        // Act
        ResponseEntity<String> response = controller.registerUser(requestDto);

        // Assert
        assertEquals(ResponseEntity.ok("User registered successfully."), response);
    }

    @Test
    public void testRegisterUser_invalidUserType() {
        // Arrange
        UserRequestDto requestDto = new UserRequestDto("John Doe", "john@example.com", "what");
        UserController controller = new UserController(driverService, riderService);

        // Act
        ResponseEntity<String> response = controller.registerUser(requestDto);

        // Assert
        assertEquals(ResponseEntity.badRequest().body("Invalid user type."), response);
    }
}
