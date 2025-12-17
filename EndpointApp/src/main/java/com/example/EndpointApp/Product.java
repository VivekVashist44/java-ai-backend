package com.example.EndpointApp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

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