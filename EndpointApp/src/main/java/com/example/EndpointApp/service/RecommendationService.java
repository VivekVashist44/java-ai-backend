package com.example.EndpointApp.service;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EndpointApp.Product;
import com.example.EndpointApp.dto.ApiResponse;
import com.example.EndpointApp.dto.ProductRequest;
import com.example.EndpointApp.exception.ProductNotFoundException;
import com.example.EndpointApp.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class RecommendationService {

    private final ProductRepository repository;

    public RecommendationService(ProductRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<ApiResponse<List<ProductRequest>>> result(Integer productId) {
        Product res = repository.findById(productId).orElse(null);
        if (res == null) {
            throw new ProductNotFoundException(productId);
        }
        String cat = res.getCategory();
        ArrayList<Product> result = repository.findByCategoryAndIdNot(cat, productId);
        List<ProductRequest> arrResult = result.stream().map(this::mapToDto).collect(Collectors.toList());

        ApiResponse<List<ProductRequest>> resultResponse = new ApiResponse<>();
        resultResponse.setData(arrResult);
        resultResponse.setSucess(true);
        resultResponse.setMessage("Recommendations fetched successfully");
        resultResponse.setTimestamp(java.time.LocalDateTime.now());
        resultResponse.setStatus(HttpStatus.OK);
        return ResponseEntity.ok(resultResponse);
    }

    public ResponseEntity<ApiResponse<Page<ProductRequest>>> getAll(Pageable pageable) {
        Page<Product> products = repository.findAll(pageable);
        Page<ProductRequest> productDtos = products.map(this::mapToDto);
        ApiResponse<Page<ProductRequest>> response = new ApiResponse<>();
        response.setData(productDtos);
        response.setSucess(true);
        response.setMessage("Products fetched successfully");   
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ApiResponse<ProductRequest>> getById(Integer id) {
        // return ResponseEntity.ok(repository.findById(id));
        // Product res = repository.findById(id).orElse(null);
        // if(res==null){
        // throw new ProductNotFoundException(id);
        // }
        // return ResponseEntity.ok(repository.findById(id));

        Product res = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        ProductRequest dto = mapToDto(res);
        ApiResponse<ProductRequest> response = new ApiResponse<>();
        response.setData(dto);
        response.setSucess(true);
        response.setMessage("Product fetched successfully");
        response.setTimestamp(java.time.LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<ApiResponse<ProductRequest>> save(ProductRequest product) {

        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setCategory(product.getCategory());
        Product savedProduct = repository.save(newProduct);
        ProductRequest dto = mapToDto(savedProduct);
        ApiResponse<ProductRequest> response = new ApiResponse<>();
        response.setData(dto);
        response.setSucess(true);
        response.setMessage("Product created successfully");
        response.setTimestamp(java.time.LocalDateTime.now());
        response.setStatus(HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Transactional
    public ResponseEntity<ApiResponse<ProductRequest>> update(Integer id, Product product) {
        Product res = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        if (product.getName() != null) {
            res.setName(product.getName());
        }
        if (product.getCategory() != null) {
            res.setCategory(product.getCategory());
        }
        repository.save(res);

        ProductRequest dto = mapToDto(res);
        ApiResponse<ProductRequest> response = new ApiResponse<>();
        response.setData(dto);
        response.setSucess(true);
        response.setMessage("Product Updated Sucessfully");
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.OK);
        return ResponseEntity.ok(response);

    }

    private ProductRequest mapToDto(Product product) {
        ProductRequest dto = new ProductRequest(product.getName(), product.getCategory());
        dto.setId(product.getId());
        return dto;
    }

    public ResponseEntity<ApiResponse<Object>> delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            ApiResponse<Object> response = new ApiResponse<>();
            response.setData(null);
            response.setSucess(true);
            response.setMessage("Product Deleted Sucessfully");
            response.setTimestamp(LocalDateTime.now());
            response.setStatus(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        throw new ProductNotFoundException(id);
    }
}
