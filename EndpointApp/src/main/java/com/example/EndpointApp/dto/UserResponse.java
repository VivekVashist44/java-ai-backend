package com.example.EndpointApp.dto;

import com.example.EndpointApp.entity.enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserResponse {
    
    private Integer id;

    @NotBlank(message = "Name can't be blank")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    private Role role;

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Role getRole() {
        return this.role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public UserResponse(Integer id, String username, Role role){
        this.id=id;
        this.username=username;
        this.role=role;
    }
    
    public UserResponse(Integer id, String username, String email,Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role =role;
    }
}
