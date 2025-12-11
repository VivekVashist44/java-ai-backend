package com.example.EndpointApp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
    public record ErrorResponse(

            LocalDateTime timestamp,
            HttpStatus status,
            String error,
            String message,
            String path

    ){}
    
