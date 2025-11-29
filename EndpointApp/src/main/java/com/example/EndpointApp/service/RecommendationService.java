package com.example.EndpointApp.service;

import java.util.ArrayList;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EndpointApp.Product;
import com.example.EndpointApp.repository.ProductRepository;

@Service
public class RecommendationService {

    private final ProductRepository repository;

    public RecommendationService(ProductRepository repository){
        this.repository=repository;
    }
    public ResponseEntity<?> result(Integer productId){
        Product res=repository.findById(productId).orElse(null);
        if(res == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error","Invalid Product Id"));
        }

        String cat= res.getCategory();
        ArrayList<Product> allProducts=(ArrayList<Product>)repository.findAll();
        ArrayList<Product> result = new ArrayList<>();

        for(Product p :allProducts){
            if(cat.equals(p.getCategory()) && productId!=p.getId()){
                result.add(p);
            }
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    public ResponseEntity<?> save(Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
    }
}
