package com.healthcare.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.app.dto.LoginRequest;
import com.healthcare.app.dto.RegisterRequest;
import com.healthcare.app.entity.User;
import com.healthcare.app.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register API
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    // Login API
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}


