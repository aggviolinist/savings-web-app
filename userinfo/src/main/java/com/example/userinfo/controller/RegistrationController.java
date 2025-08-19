package com.example.userinfo.controller;

import com.example.userinfo.model.User;
import com.example.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        try {
            registrationService.registerUser(request.getUsername(), request.getPassword());
            return ResponseEntity.ok("User registered successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

    // @PostMapping("/api/register")
    // public String registerUser(@RequestBody User user) {
    //     userRepository.save(user); // Corrected instance variable call
    //     return "User registered successfully!";
    // }