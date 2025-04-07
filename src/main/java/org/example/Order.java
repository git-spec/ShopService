package org.example;

public record Order(
        String id,
        Product product,
        int amount,
        double total
        ) {
}
