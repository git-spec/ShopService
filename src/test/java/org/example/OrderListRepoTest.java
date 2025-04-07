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

    @Test
    void getOrder_shouldReturnEmpty_whenProductDoNotExists() {
        //GIVEN
        String id = "000002";
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
        Optional<Order> expected = Optional.empty();
        // WHEN
        OrderListRepo list = new OrderListRepo();
        list.addOrder(order);
        Optional<Order> actual = list.getOrder(id);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void removeOrder_shouldHaveNotOrder_whenOrderIsRemoved() {
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
        Optional<Order> expected = Optional.empty();
        //wHEN
        OrderListRepo orderList = new OrderListRepo();
        orderList.addOrder(order);
        orderList.removeOrder(id);
        Optional<Order> actual = orderList.getOrder(id);
        // THEN
        assertEquals(expected, actual);
    }

    @Test
    void removeAll_shouldBeEmpty_whenAllOrdersAreCleared() {
        // GIVEN
        String id = "000001";
        Order order_1 = new Order(
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
        Order order_2 = new Order(
                "000002",
                new Product(
                        "567890",
                        "Birne",
                        0.79,
                        1
                ),
                1,
                0.79
        );
        Optional<Order> expected = Optional.empty();
        //wHEN
        OrderListRepo orderList = new OrderListRepo();
        orderList.addOrder(order_1);
        orderList.addOrder(order_2);
        orderList.removeAll();
        // THEN
        assertTrue(orderList.getOrders().isEmpty());
    }
}