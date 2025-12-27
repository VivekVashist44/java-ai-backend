package com.example.EndpointApp.dto;

import com.example.EndpointApp.entity.enums.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserResponse {
    
    @NotBlank(message = "Name can't be blank")
    private String username;

    @Size(min = 4)
    private String password;
    
    private String email;
    

    private Role role;

    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
