package com.example.EndpointApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.example.EndpointApp.Product;
import com.example.EndpointApp.exception.ProductNotFoundException;
import com.example.EndpointApp.repository.ProductRepository;

public class RecommendationServiceTest {

    private ProductRepository repository;
    private RecommendationService service;


    @BeforeEach
    void setup(){
        repository = Mockito.mock(ProductRepository.class);
        service = new RecommendationService(repository);
    }


    // @Test
    // void sample_testForMe(){

    //     Product p1 = new Product(1, "Lays", "Food");
    //     Product p2 = new Product(2, "Banana", "Food");
    //     Product p3 = new Product(3, "Orange", "Food");

    //     List<Product> products = new ArrayList<>(Arrays.asList(p1, p2, p3));

    //     when(repository.findById(1)).thenReturn(Optional.of(p1));
    //     when(repository.findAll()).thenReturn(products);

    //     ResponseEntity<?> response = service.result(1);
    //     assertEquals(200, response.getStatusCode().value());

    //     List<Product> body = (List<Product>) response.getBody();
    //     assertEquals(1, body.size());
    //     assertEquals(2, body.get(0).getId());
    //     assertEquals("Food", body.get(0).getCategory());
    // }
    @Test
    void result_ValidProductId_returnsRecommendedProducts(){

        Product p1=new Product(1,"Lays","Food");
        Product p2 = new Product(2, "Banana", "mug");
        Product p3=new Product(3,"Orange","Food");

        List<Product> products = new ArrayList<>(Arrays.asList(p1, p2, p3));


        when(repository.findById(1)).thenReturn(Optional.of(p1));
        when(repository.findAll()).thenReturn(products);

        ResponseEntity<?> response =service.result(1);
        assertEquals(200, response.getStatusCode().value());

        List<Product> body = (List<Product>) response.getBody();
        assertEquals(1, body.size());
        assertEquals(3, body.get(0).getId());
        assertEquals("Food", body.get(0).getCategory());
        
    }

    @Test
    void result_invalidProductId_throwsException() {

        when(repository.findById(999)).thenReturn(Optional.empty());
        assertThrows(ProductNotFoundException.class, ()->service.result(999));
    }
}   
