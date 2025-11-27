package com.example.EndpointApp.service;

import java.util.ArrayList;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EndpointApp.Product;

@Service
public class RecommendationService {
    public ResponseEntity<?> result(int productId,ArrayList<Product> arr1){
        String cat = null;
        ArrayList<Product> result=new ArrayList<>();
        boolean flag=false;
        for (int i = 0; i < arr1.size(); i++) {
            if (productId == arr1.get(i).getId()) {
                cat = arr1.get(i).getCategory();
                flag=true;
            }
        }
        if(flag==false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error","Invalid product id or Product id not found"));
            }
            for (int i = 0; i < arr1.size(); i++) {
                if (cat.equals(arr1.get(i).getCategory()) && productId!=arr1.get(i).getId())
                {
                    result.add(arr1.get(i));

                }
            System.out.println("This is my arraylist" + result);
        }
        return ResponseEntity.ok(result);
    }
}
