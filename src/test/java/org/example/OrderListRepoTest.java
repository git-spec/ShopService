package org.example;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void getOrder_shouldReturnOrder_whenOrderExists() {
        // GIVEN
        String id = "000001";
        Order order = new Order(
                "000001",
                new Product(
                        "123456",
                        "Apfel",
                        0.69,
                        2
                ),
                2,
                1.38
        );
        // WHEN
        OrderListRepo list = new OrderListRepo();
        list.addOrder(order);
        Optional<Order> actual = list.getOrder(id);
        // THEN
        assertTrue(actual.isPresent());
    }
}