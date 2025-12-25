package com.example.EndpointApp.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EndpointApp.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Page<Product> findAll(Pageable pageable);
    public ArrayList<Product> findByCategoryAndIdNot(String category,Integer productId);
}
