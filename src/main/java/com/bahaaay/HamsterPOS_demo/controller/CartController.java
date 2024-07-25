package com.bahaaay.HamsterPOS_demo.controller;

import com.bahaaay.HamsterPOS_demo.model.Cart;
import com.bahaaay.HamsterPOS_demo.model.Product;
import com.bahaaay.HamsterPOS_demo.service.CartService;
import com.bahaaay.HamsterPOS_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add/{productId}/{quantity}")
    public ResponseEntity<String> addProductToCart(@PathVariable Long productId, @PathVariable int quantity) {
        Product product = productService.getProductById(productId).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        String result = cartService.addProductToCart(product, quantity);
        if (result.equals("Product added to cart.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long productId) {
        Product product = productService.getProductById(productId).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        cartService.removeProductFromCart(product);
        return ResponseEntity.ok(cartService.getCart());
    }

    @GetMapping
    public ResponseEntity<Cart> viewCart() {
        return ResponseEntity.ok(cartService.getCart());
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout() {
        String result = cartService.checkout();
        if (result.equals("Order placed successfully. Cart is now empty.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
