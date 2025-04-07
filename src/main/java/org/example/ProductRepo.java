package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Optional<Product> getProduct(String id) {
        Product product = null;
        for (Product p : products) if (p.id().equals(id)) product = p;
        return product == null ? Optional.empty() : Optional.of(product);
    }

    public void removeProduct(String id) {
        this.products.removeIf(product -> product.id().equals(id));
    }

    public void removeAll() {
        this.products.clear();
    }
}
