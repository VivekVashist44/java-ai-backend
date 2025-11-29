package com.example.EndpointApp.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EndpointApp.Product;
import com.example.EndpointApp.repository.ProductRepository;
import com.example.EndpointApp.service.RecommendationService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WelcomeEndpoint {

    private final RecommendationService recommendationService;
    
    // ArrayList<Product> arr1 = new ArrayList<>();
    // ArrayList<Product> arr2 =new ArrayList<>();

    public WelcomeEndpoint(RecommendationService recommendationService) {

        this.recommendationService = recommendationService;

        // Product pt1 = new Product(1, "Lays", "Food");
        // Product pt2 = new Product(2, "Kurkure", "Food");
        // Product pt3 = new Product(3, "book", "Essential");
        // Product pt4 = new Product(4, "car", "Essential");
        // Product pt5 = new Product(5, "milk", "Food");
        // Product pt6 = new Product(6, "laptop", "Electronics");

        // arr1.add(pt1);
        // arr1.add(pt2);
        // arr1.add(pt3);
        // arr1.add(pt4);
        // arr1.add(pt5);
        // arr1.add(pt6);
    }

    @GetMapping("/recommendation")
    public ResponseEntity<?> recommend(@RequestParam int productId) {
            return recommendationService.result(productId);

    }

    // public HttpStatus response(){
    //     return HttpStatus.BAD_REQUEST;
    // }
    @GetMapping("/products")
    public ResponseEntity<?> allProducts(){
        return recommendationService.getAll();
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, AI Backend!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "! Welcome to AI Backend";
    }
}