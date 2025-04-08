package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ShopService {
    public final OrderRepo orderList = new OrderListRepo();
    public final ProductRepo productRepo = new ProductRepo();

    /**
     * Places an order into order list after ckecking existence of products.
     * @param requests  an array of maps with product id and amount
     */
    public void placeOrder(List<Map<String, String>> requests) {
        for (Map<String, String> request : requests) {
            // Checks existence of product.
            Optional<Product> product = checkProduct(productRepo.getProducts(), request.get("id"));
            if (!product.equals(Optional.empty())) {
                // Sets order.
                int amount = Integer.parseInt(request.get("amount"));
                orderList.addOrder(new Order(UUID.randomUUID().toString(), product.orElseThrow(), amount, amount * product.get().price()));
            }
        }
    }

    /**
     * Checks existence of a product in the product repository.
     * @param products  available products
     * @param productID product id
     * @return optional of a product or empty
     */
    public Optional<Product> checkProduct(List<Product> products, String productID) {
        Optional<Product> result = Optional.empty();
        for (Product product: products) if (product.id().equals(productID)) result = Optional.of(product);
        if (result.equals(Optional.empty())) System.out.println("Product ID " + productID + " does not exist.");
        return result;
    }

    /**
     * Prints orders.
     */
    public void showOrders() {
        orderList.getOrders().forEach(System.out::println);
        System.out.println("\n");
        for (Order order: orderList.getOrders()) {
            System.out.println("Order-ID: " + order.id());
            System.out.println("Product: " + order.product().name());
            System.out.println("Price: " + order.product().price());
            System.out.println("Amount: " + order.amount());
            System.out.println("Total: " + order.total() + "\n");
        }
    }
}
