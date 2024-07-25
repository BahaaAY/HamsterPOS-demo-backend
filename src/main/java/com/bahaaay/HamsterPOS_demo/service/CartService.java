package com.bahaaay.HamsterPOS_demo.service;

import com.bahaaay.HamsterPOS_demo.model.Cart;
import com.bahaaay.HamsterPOS_demo.model.Product;
import com.bahaaay.HamsterPOS_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;

    private final Cart cart = new Cart();

    public String addProductToCart(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            return "Not enough stock for product: " + product.getName();
        }
        cart.addProduct(product, quantity);
        return "Product added to cart.";
    }

    public void removeProductFromCart(Product product) {
        cart.removeProduct(product);
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalPrice() {
        return cart.getTotalPrice();
    }

    public double getDiscountedPrice() {
        return cart.getDiscountedPrice();
    }

    public String checkout() {
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product.getQuantity() < quantity) {
                return "Not enough stock for product: " + product.getName();
            }
        }

        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
        }
        cart.clear();
        return "Order placed successfully. Cart is now empty.";
    }
}
