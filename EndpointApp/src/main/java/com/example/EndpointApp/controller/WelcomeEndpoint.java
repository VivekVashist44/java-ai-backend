package com.example.EndpointApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EndpointApp.dto.ApiResponse;
import com.example.EndpointApp.dto.ProductRequest;
import com.example.EndpointApp.entity.Product;
import com.example.EndpointApp.service.RecommendationService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.RequestParam;

@Validated
@RestController
public class WelcomeEndpoint {

    private final RecommendationService recommendationService;

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
    @GetMapping("/")
    public String Dashboard(){
        return "Welcome to homepage";
    }

    @GetMapping("/recommendation")
    public ResponseEntity<ApiResponse<Page<ProductRequest>>> recommend(
        @Min(1) @RequestParam int productId,
        @PageableDefault(size = 10, page = 0) Pageable pageable) {
            return recommendationService.result(productId,pageable);

    }
    @GetMapping("/products")
    public ResponseEntity<ApiResponse<Page<ProductRequest>>> allProducts(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) String name,
        @PageableDefault(size = 10, page = 0) Pageable pageable){
        return recommendationService.getAll(Optional.ofNullable(name),Optional.ofNullable(category),pageable);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ApiResponse<ProductRequest>> productById(@PathVariable @Min(1) Integer id){
        return recommendationService.getById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<ApiResponse<ProductRequest>> createProduct(@Valid @RequestBody ProductRequest product){
        return recommendationService.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ApiResponse<ProductRequest>> updateProduct(@PathVariable @Min(1) Integer id,@RequestBody Product product){
        return recommendationService.update(id, product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteProduct(@PathVariable @Min(1) Integer id){
        return recommendationService.delete(id);
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "! Welcome to AI Backend";
    }
}