package com.example.dummyjson.service;

import com.example.dummyjson.dto.Product;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private MockWebServer mockWebServer;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }
    @Test
    public void testGetAllProducts() {
        
        mockWebServer.enqueue(new MockResponse()
                .setBody("{\"products\": [{\"id\": 1, \"title\": \"Essence Mascara Lash Princess\"}, {\"id\": 2, \"title\": \"Product 2\"}]}")
                .addHeader("Content-Type", "application/json"));

        
        List<Product> products = productService.getAllProducts();

        
        assertNotNull(products);
        assertEquals(30, products.size());
        assertEquals("Essence Mascara Lash Princess", products.get(0).getTitle());
    }



    @Test
    public void testGetProductById() {
        
        mockWebServer.enqueue(new MockResponse()
                .setBody("{\"id\": 1, \"title\": \"Essence Mascara Lash Princess\"}")
                .addHeader("Content-Type", "application/json"));

        
        Product product = productService.getProductById(1L);

        
        assertNotNull(product);
        assertEquals(1L, product.getId());
        assertEquals("Essence Mascara Lash Princess", product.getTitle());
    }
}
