package com.example.EndpointApp.service;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.EndpointApp.Product;
import com.example.EndpointApp.dto.ProductRequest;
import com.example.EndpointApp.exception.ProductNotFoundException;
import com.example.EndpointApp.repository.ProductRepository;


@Service
public class RecommendationService {

    private final ProductRepository repository;

    public RecommendationService(ProductRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> result(Integer productId) {
        Product res = repository.findById(productId).orElse(null);
        if (res == null) {
            throw new ProductNotFoundException(productId);
        }

        String cat = res.getCategory();
        // ArrayList<Product> allProducts = (ArrayList<Product>) repository.findAll();
        // ArrayList<Product> result = new ArrayList<>();

        // for (Product p : allProducts) {
        //     if (cat.equals(p.getCategory()) && productId != p.getId()) {
        //         result.add(p);
        //     }
        // }

        ArrayList<Product> result = repository.findByCategoryAndIdNot(cat, productId);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    public ResponseEntity<?> getById(Integer id){
        // return ResponseEntity.ok(repository.findById(id));
        Product res = repository.findById(id).orElse(null);
        if(res==null){
            throw new ProductNotFoundException(id);
        }
        return ResponseEntity.ok(repository.findById(id));
    }

    public ResponseEntity<?> save(ProductRequest product) {

        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setCategory(product.getCategory());
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newProduct));
    }

    public ResponseEntity<?> update(Integer id, Product product) {
        Product res = repository.findById(id).orElse(null);
        if (res == null) {
            throw new ProductNotFoundException(id);
        }
        if (product.getName() != null) {
            res.setName(product.getName());
        }
        if (product.getCategory() != null) {
            res.setCategory(product.getCategory());
        }
        repository.save(res);
        return ResponseEntity.ok(res);

    }

    public ResponseEntity<?> delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        throw new ProductNotFoundException(id);
    }
}
