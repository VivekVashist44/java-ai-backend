package com.example.EndpointApp.service;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EndpointApp.dto.ApiResponse;
import com.example.EndpointApp.dto.UserRegisterRequest;
import com.example.EndpointApp.dto.UserResponse;
import com.example.EndpointApp.entity.User;
import com.example.EndpointApp.repository.UserRepository;

@Service
public class UserService {
    
    // private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;

    // public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    // public ResponseEntity<ApiResponse<UserResponse>> registerUser(UserResponse userResponse){
        
    //     User res = userRepository.findByUsername(userResponse.getUsername());
    //     if(res != null){
    //         throw new RuntimeException("Username already exists");
    //     }
    //     User user=new User();
    //     user.setUsername(userResponse.getUsername());
    //     user.setEmail(userResponse.getEmail());
    //     user.setPassword(passwordEncoder.encode(userResponse.getPassword()));
    //     // user.setRole(userResponse.getRole());

    //     userRepository.save(user);

    //     ApiResponse<UserResponse> response=new ApiResponse<>();
    //     response.setData(userResponse);
    //     response.setMessage("User registered successfully");
    //     response.setSucess(true);
    //     response.setTimestamp(LocalDateTime.now());
    //     response.setStatus(HttpStatus.CREATED);
    //     return new ResponseEntity<>(response,HttpStatus.CREATED);

    // }
}
