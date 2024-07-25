package com.bahaaay.HamsterPOS_demo.controller;

import com.bahaaay.HamsterPOS_demo.model.Product;
import com.bahaaay.HamsterPOS_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
}
