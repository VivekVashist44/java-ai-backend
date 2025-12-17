package com.example.EndpointApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {
    
    @NotBlank(message = "Name can't be empty/blank")
    @Size(min = 3)
    private String name;


    @NotBlank(message = "Category can't be empty/blank")
    @Size(min = 3)
    private String category;

    public String getName(){
        return this.name;
    }

    public void setName(String name ){
        this.name =name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public ProductRequest(String name,String category){
        this.name = name;
        this.category =category;
    }
}
