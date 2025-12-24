package com.example.EndpointApp.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {
    private T data;
    private boolean sucess;
    private String message;
    private LocalDateTime timestamp;
    private HttpStatus status;



    public T getData() {
        return this.data;
    }
    public void setData(T data){
        this.data=data;
    }
    public boolean isSucess() {
        return this.sucess;
    }
    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public HttpStatus getStatus() {
        return this.status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
