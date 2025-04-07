package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void placeOrder_shouldCreateNewOrder_whenGettingRequest() {
        // GIVEN
        ShopService shopService = new ShopService();
        Product product = new Product(
                "123456",
                "Apfel",
                0.69,
                0.69
        );
        Map<String, String> request = new HashMap<>();
        List<Map<String, String>> requests = new ArrayList<>();

        shopService.productRepo.addProduct(product);
        request.put("id", "123456");
        request.put("amount", "4");
        requests.add(request);
        // WHEN
        shopService.placeOrder(requests);
        // THEN
        assertFalse(shopService.orderList.getOrders().isEmpty());
        assertEquals("123456", shopService.orderList.getOrders().getFirst().product().id());
    }

    @Test
    void checkProduct_shouldReturnProduct_whenLookingForID() {
        // GIVEN
        ShopService shopService = new ShopService();
        Product expected = new Product(
                "123456",
                "Apfel",
                0.69,
                0.69
        );
        String productID = "123456";

        shopService.productRepo.addProduct(expected);
        // WHEN
        Product actual = shopService.productRepo.getProductByID(productID).get();
        // THEN
        assertEquals(expected, actual);
    }
}