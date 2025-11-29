package com.example.EndpointApp.service;

import java.util.ArrayList;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

    // public ResponseEntity<?> result(int productId){
    //     String cat = null;
    //     ArrayList<Product> result=new ArrayList<>();
    //     boolean flag=false;
    //     Product res = repository.findById(productId);
    //     if(res!=null){
    //         cat = res.getCategory();    
    //     }
    //     else{
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Invalid product id or Product id not found"));
    //     }

    //     for (int i = 0; i < repository.getAllProducts().size(); i++) {
    //         if (cat.equals(repository.getAllProducts().get(i).getCategory())
    //                 && productId != repository.getAllProducts().get(i).getId()) {
    //             result.add(repository.getAllProducts().get(i));
    //         }
    //     }
    //     return ResponseEntity.ok(result);
        

    //     // if(cat.isEmpty()){
    //     //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error","Invalid product id or Product id not found"));
    //     // }
    //     // for (int i = 0; i < arr1.size(); i++) {
    //     //     if (cat.equals(arr1.get(i).getCategory()) && productId!=arr1.get(i).getId())
    //     //         {
    //     //             result.add(arr1.get(i));
    //     //         }
    //     //     System.out.println("This is my arraylist" + result);
    //     // }
    //     // return ResponseEntity.ok(result);

    //     // if(!cat.isEmpty()){
            
    //     // }
    //     // else{
    //     //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Invalid product id or Product id not found"));
    //     // }
    // }

    public ResponseEntity<?> result(int productId){
        Product res=repository.findById(productId);
        if(res == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error","Invalid Product Id"));
        }

        String cat= res.getCategory();
        ArrayList<Product> allProducts=repository.getAllProducts();
        ArrayList<Product> result = new ArrayList<>();

        for(Product p :allProducts){
            if(cat.equals(p.getCategory()) && productId!=p.getId()){
                result.add(p);
            }
        }
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> getAll(){
        if(repository.getAllProducts()!=null){
            return ResponseEntity.ok(repository.getAllProducts());
        }
        else{
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }
        
    }
}
