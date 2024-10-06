package com.example.dummyjson.dto.response;

import com.example.dummyjson.dto.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private List<Product> products;


}
