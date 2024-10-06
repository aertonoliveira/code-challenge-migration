package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private WebClient webClient;

    public List<Product> getAllProducts() {
        ProductResponse response = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ProductResponse.class)  
                .block();  

        return response.getProducts();  
    }


    public Product getProductById(Long id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();  
    }
}
