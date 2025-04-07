package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService();
        Product product_1 = new Product(
                "123456",
                "Apfel",
                0.69,
                0.69
        );
        Product product_2 = new Product(
                "567890",
                "Birne",
                0.79,
                0.79
        );
        Product product_3 = new Product(
                "918273",
                "Mango",
                1.79,
                1.79
        );
        shopService.productRepo.addProduct(product_1);
        shopService.productRepo.addProduct(product_2);
        shopService.productRepo.addProduct(product_3);

        Map<String, String> request_1 = new HashMap<>();
        request_1.put("id", "123456");
        request_1.put("amount", "4");
        Map<String, String> request_2 = new HashMap<>();
        request_2.put("id", "567890");
        request_2.put("amount", "3");
        List<Map<String, String>> requests = new ArrayList<>();
        requests.add(request_1);
        requests.add(request_2);

        shopService.placeOrder(requests);

        System.out.println(shopService.getOrderList());
        System.out.println("Order ID: " + OrderListRepo.orderID);
    }
}