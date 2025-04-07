package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ShopService {
    OrderListRepo orderList = new OrderListRepo();
    ProductRepo productRepo = new ProductRepo();

    /**
     * Places an order into order list after ckecking existence of products.
     * @param requests  an array of maps with product id and amount
     */
    public void placeOrder(List<Map<String, String>> requests) {
        for (Map<String, String> request : requests) {
            // Checks existence of product.
            Optional<Product> product = checkProduct(productRepo.getProducts(), request.get("id"));
            if (!product.equals(Optional.empty())) {
                // Changes order id into integer.
                int orderID = Integer.parseInt(request.get("id"));
                // Sets new order id.
                orderID += orderID;
                // Sets order.
                orderList.addOrder(new Order(OrderListRepo.orderID, product.orElseThrow(), orderID));
                // Saves new order id as string.
                OrderListRepo.orderID = Integer.toString(orderID);
            }
        }
    }

    /**
     * Checks existence of a product in the product repository.
     * @param products  available products
     * @param productID product id
     * @return optional of a product
     */
    public Optional<Product> checkProduct(List<Product> products, String productID) {
        Optional<Product> result = Optional.empty();
        for (Product product: products) if (product.id().equals(productID)) result = Optional.of(product);
        if (result.equals(Optional.empty())) System.out.println("Product ID " + productID + " does not exist.");
        return result;
    }
}
