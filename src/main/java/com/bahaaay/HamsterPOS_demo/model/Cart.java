package com.bahaaay.HamsterPOS_demo.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart {

    private Map<Product, Integer> products = new HashMap<>();
    private double totalPrice;
    private double discountedPrice;

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
        updatePrices();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        updatePrices();
    }

    public void clear() {
        products.clear();
        updatePrices();
    }

    public void updatePrices() {
        totalPrice = products.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
        discountedPrice = totalPrice > 100 ? totalPrice * 0.9 : totalPrice;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
