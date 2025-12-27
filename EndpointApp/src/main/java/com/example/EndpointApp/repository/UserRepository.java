package com.example.EndpointApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EndpointApp.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
