// package com.example.EndpointApp.repository;

// import java.util.ArrayList;

// import org.springframework.stereotype.Repository;

// import com.example.EndpointApp.Product;

// @Repository
// public class ProductRepository {

//     private final ArrayList<Product> arr1 = new ArrayList<>();

//     public ProductRepository(){

//         Product pt1 = new Product(1, "Lays", "Food");
//         Product pt2 = new Product(2, "Kurkure", "Food");
//         Product pt3 = new Product(3, "book", "Essential");
//         Product pt4 = new Product(4, "car", "Essential");
//         Product pt5 = new Product(5, "milk", "Food");
//         Product pt6 = new Product(6, "laptop", "Electronics");

//         arr1.add(pt1);
//         arr1.add(pt2);
//         arr1.add(pt3);
//         arr1.add(pt4);
//         arr1.add(pt5);
//         arr1.add(pt6);
//     }
//     public ArrayList<Product> getAllProducts(){
//         return arr1;
//     }

//     public Product findById(int productId){
//         for(int i=0;i<arr1.size();i++){
//             if(productId == arr1.get(i).getId()){
//                 return arr1.get(i);
                
//             }
//         }
//         return null;
//     }
// }

package com.example.EndpointApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EndpointApp.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
