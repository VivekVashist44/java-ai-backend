package com.example.EndpointApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class WelcomeEndpoint {
    ArrayList<Product> arr1 = new ArrayList<>();

    public WelcomeEndpoint() {

        Product pt1 = new Product(1, "Lays", "Food");
        Product pt2 = new Product(2, "Kurkure", "Food");
        Product pt3 = new Product(3, "book", "Essential");
        Product pt4 = new Product(4, "car", "Essential");
        Product pt5 = new Product(5, "milk", "Food");
        Product pt6 = new Product(6, "laptop", "Electronics");

        arr1.add(pt1);
        arr1.add(pt2);
        arr1.add(pt3);
        arr1.add(pt4);
        arr1.add(pt5);
        arr1.add(pt6);
    }

    @GetMapping("/recommendation")
    public ArrayList<Product> recommend(@RequestParam int productId) {
        String cat = null;
        ArrayList<Product> result=new ArrayList<>();
        for (int i = 0; i < arr1.size(); i++) {
            if (productId == arr1.get(i).getId()) {
                System.out.println("We have reached the destination with checklpoint =1");
                cat = arr1.get(i).getCategory();
                System.out.println(cat);
            }
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (cat.equals(arr1.get(i).getCategory()) && productId!=arr1.get(i).getId()) {
                System.out.print("We have reached the destination with checklpoint =2");
                result.add(arr1.get(i));
            }
        }

        return result;

    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello, AI Backend!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello ," + name + "! Welcome to AI Backend";
    }
}