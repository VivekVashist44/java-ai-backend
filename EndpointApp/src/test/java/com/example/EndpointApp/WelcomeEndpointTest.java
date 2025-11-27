package com.example.EndpointApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.EndpointApp.controller.WelcomeEndpoint;
import com.example.EndpointApp.service.RecommendationService;

public class WelcomeEndpointTest {

    WelcomeEndpoint welcomeEndpoint;

    @BeforeEach
    public void setup(){
        RecommendationService recommendationService =new RecommendationService();
        welcomeEndpoint = new WelcomeEndpoint(recommendationService);
    }
    @Test
    public void testRecommendInvalidInput(){
        // Test with invalid productId
        ResponseEntity<?> responseInvalid = welcomeEndpoint.recommend(-1);
        assertEquals(HttpStatus.NOT_FOUND, responseInvalid.getStatusCode());
        assertTrue(((Map)responseInvalid.getBody()).containsKey("error"));
    }

    @Test
    public void testRecommendValidInput(){

        // Test with valid productId that exists in arr1
        int testProductId = 1; // Using first element's ID for test
        ResponseEntity<?> responseValid = welcomeEndpoint.recommend(testProductId);
        assertEquals(HttpStatus.OK, responseValid.getStatusCode());

        // The result body should be an ArrayList of products in the same category except the product itself
        ArrayList<Product> recommendedProducts = (ArrayList<Product>) responseValid.getBody();
        for (Product p : recommendedProducts) {
            assertEquals("Food", p.getCategory());
            assertNotEquals(testProductId, p.getId());
        }
    }
    
}
