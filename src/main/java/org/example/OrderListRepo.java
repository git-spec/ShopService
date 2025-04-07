package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderListRepo {
    private final List<Order> orders;

    public OrderListRepo() {
        this.orders = new ArrayList<Order>();
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderListRepo that)) return false;
        return Objects.equals(getOrders(), that.getOrders());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getOrders());
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }

    public Optional<Order> getOrder(String id) {
        Optional<Order> result = Optional.empty();
        for (Order order : orders) if (order.id().equals(id)) result = Optional.of(order);
        return result;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(String id) {
        this.orders.removeIf(order -> order.id().equals(id));
    }

    public void removeAll() {
        this.orders.clear();
    }
}
