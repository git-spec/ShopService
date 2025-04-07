package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private final List<Product> products;

    public ProductRepo() {
        this.products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductRepo that)) return false;
        return Objects.equals(getProducts(), that.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getProducts());
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
}
