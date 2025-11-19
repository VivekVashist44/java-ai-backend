package com.example.EndpointApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WelcomeEndpoint{
    @GetMapping("/welcome")
    public String welcome(){
        return "Hello, AI Backend!";
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Hello ,"+name+"! Welcome to AI Backend";
    }
}