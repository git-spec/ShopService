package org.example;

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private Map<String, Order> orders = new HashMap<>();

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Optional<Order> getOrderByID(String id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.id(), order);
    }

    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }

    @Override
    public void removeAll() {
        orders.clear();
    }
}
