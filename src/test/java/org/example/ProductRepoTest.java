package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void getProducts_shouldReturnProduct_whenProductExists() {
        //GIVEN
        String id = "123456";
        Product expected = new Product("123456", "Apfel", 0.69, 20);
        // WHEN
        ProductRepo repo = new ProductRepo();
        repo.addProduct(expected);
        Optional<Product> actual = repo.getProduct(id);
        // THEN
        assertEquals(expected, actual.orElse(null));
    }

    @Test
    void getProducts_shouldReturnEmpty_whenProductDoNotExists() {
        //GIVEN
        String id = "123457";
        Product product = new Product("123456", "Apfel", 0.69, 20);
        Optional<Product> expected = Optional.empty();
        // WHEN
        ProductRepo repo = new ProductRepo();
        repo.addProduct(product);
        Optional<Product> actual = repo.getProduct(id);
        // THEN
        assertEquals(expected, actual);
    }
}