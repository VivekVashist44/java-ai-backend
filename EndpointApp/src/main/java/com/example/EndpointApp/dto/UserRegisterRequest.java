package com.example.EndpointApp.dto;

import com.example.EndpointApp.entity.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterRequest {

    @NotBlank(message = "Name can't be blank")
    private String username;

    @NotBlank(message = "Password can't be blank")
    @Size(min = 6)
    private String password;
    
    @Email(message = "Email should be valid")
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
    public Role getRole(){
        return this.role;
    }
    public void setRole(Role role){
        this.role=role;
    }

    public UserRegisterRequest(String username, String password,String email, Role role){
        this.username=username;
        this.password=password;
        this.email=email;
        this.role=role;
    }
}
