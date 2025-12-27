package com.example.EndpointApp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@EntityListeners(AuditListner.class)
@Entity
public class Product{

    public Product() {}

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @jakarta.validation.constraints.NotNull(message = "Name can't be Empty")
    private String name;
    @NotBlank
    @jakarta.validation.constraints.NotNull(message = "Please Enter Category")
    private String category;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name ){
        this.name =name;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public Product(int id,String name , String category){
        this.id=id;
        this.name=name ;
        this.category=category;
    }
    
}