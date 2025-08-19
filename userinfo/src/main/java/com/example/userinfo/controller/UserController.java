package com.example.userinfo.controller;

import com.example.userinfo.model.User;
import com.example.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user); // Corrected instance variable call
        return "User registered successfully!";
    }
}