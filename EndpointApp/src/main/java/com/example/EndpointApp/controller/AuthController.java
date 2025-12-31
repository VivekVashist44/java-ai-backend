package com.example.EndpointApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EndpointApp.dto.ApiResponse;
import com.example.EndpointApp.dto.UserRegisterRequest;
import com.example.EndpointApp.dto.UserResponse;
import com.example.EndpointApp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // @PostMapping("/register")
    // public ResponseEntity<ApiResponse<UserResponse>> registerUser(@Valid @RequestBody UserResponse userResponse){
    //     return userService.registerUser(userResponse);
    // }
}
