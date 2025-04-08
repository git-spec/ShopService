package org.example;

import java.util.List;
import java.util.Optional;

public interface OrderRepo {

    List<Order> getOrders();

    Optional<Order> getOrderByID(String id);

    void addOrder(Order order);

    void removeOrder(String id);

    void removeAll();
}
