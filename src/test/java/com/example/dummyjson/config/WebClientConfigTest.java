package com.example.dummyjson.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WebClientConfigTest {

    @Autowired
    private WebClient webClient;

    @Value("${spring.baseUrl}")
    private String baseUrl;

    @Test
    public void testWebClientBean() {
        
        assertNotNull(webClient, "WebClient should not be null");
    }

    @Test
    public void testBaseUrl() {
        
        String expectedBaseUrl = "https://dummyjson.com";  
        assertEquals(expectedBaseUrl, baseUrl, "Base URL should match the configured value");
    }
}
