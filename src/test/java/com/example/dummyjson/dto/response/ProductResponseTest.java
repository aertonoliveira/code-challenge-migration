package com.example.dummyjson.dto.response;

import com.example.dummyjson.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductResponseTest {

    @Test
    public void testGetAndSetProducts() {
        
        Product product1 = new Product();
        product1.setId(1L);
        product1.setTitle("Essence Mascara Lash Princess");
        product1.setPrice(9.99);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setTitle("Product 2");
        product2.setPrice(19.99);

        
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProducts(productList);

        
        List<Product> retrievedProducts = productResponse.getProducts();
        assertNotNull(retrievedProducts, "A lista de produtos não deve ser nula");
        assertEquals(2, retrievedProducts.size(), "A lista de produtos deve conter 2 itens");

        
        assertEquals(1L, retrievedProducts.get(0).getId());
        assertEquals("Essence Mascara Lash Princess", retrievedProducts.get(0).getTitle());
        assertEquals(9.99, retrievedProducts.get(0).getPrice());

        
        assertEquals(2L, retrievedProducts.get(1).getId());
        assertEquals("Product 2", retrievedProducts.get(1).getTitle());
        assertEquals(19.99, retrievedProducts.get(1).getPrice());
    }

    @Test
    public void testNoArgsConstructor() {
        // Testando o construtor sem argumentos
        ProductResponse productResponse = new ProductResponse();
        assertNull(productResponse.getProducts(), "A lista de produtos deve ser nula inicialmente");
    }

    @Test
    public void testEqualsAndHashCode() {
        // Criação de duas instâncias iguais de ProductResponse
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Essence Mascara Lash Princess");

        List<Product> productList = new ArrayList<>();
        productList.add(product);

        ProductResponse response1 = new ProductResponse();
        response1.setProducts(productList);

        ProductResponse response2 = new ProductResponse();
        response2.setProducts(productList);

        // Verificando se equals e hashCode funcionam corretamente
        assertEquals(response1, response2);
        assertEquals(response1.hashCode(), response2.hashCode());
    }
}
