package com.example.EndpointApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeEndpoint{
    @GetMapping("/welcome")
    public String welcome(){
        return "Hello, AI Backend!";
    }
}