package com.example.EndpointApp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.EndpointApp.Product;
import com.example.EndpointApp.controller.WelcomeEndpoint;
import com.example.EndpointApp.exception.ProductNotFoundException;
import com.example.EndpointApp.repository.ProductRepository;
import com.example.EndpointApp.service.RecommendationService;
import com.example.EndpointApp.service.RecommendationServiceTest;

public class WelcomeEndpointTest {

    
    WelcomeEndpoint welcomeEndpoint;
    RecommendationService mockService;

    @BeforeEach
    public void setup(){
        mockService = mock(RecommendationService.class);
        welcomeEndpoint = new WelcomeEndpoint(mockService);

        when(mockService.result(-1)).thenThrow(new ProductNotFoundException(-1));
    }
    
    @Test
    public void testRecommendInvalidInput(){
        assertThrows(ProductNotFoundException.class,() -> welcomeEndpoint.recommend(-1) );

    }

    // @Test
    // public void testRecommendValidInput(){

    // }

    // @Test
    // public void testAllProducts(){
    //     ResponseEntity<?> response =welcomeEndpoint.allProducts();
        
    //     assertEquals(HttpStatus.OK, response.getStatusCode());

    //     ArrayList<Product> products = (ArrayList<Product>) response.getBody();
        
    //     assertEquals(6,products.size() );
    // }
    
}
