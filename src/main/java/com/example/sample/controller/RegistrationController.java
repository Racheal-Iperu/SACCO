package com.example.sample.controller;

import com.example.sample.dto.RegistrationDTO;
import com.example.sample.service.UserRegistrationException;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationDTO registrationDTO) {
        try {
            userService.registerUser(registrationDTO.getUsername(), registrationDTO.getEmail(), registrationDTO.getPassword());
            return ResponseEntity.ok("Registration successful");
        } catch (UserRegistrationException e) {
            return ResponseEntity.badRequest().body("Registration failed: " + e.getMessage());
        }
    }
}
