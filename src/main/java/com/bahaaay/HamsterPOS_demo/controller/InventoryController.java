package com.bahaaay.HamsterPOS_demo.controller;

import com.bahaaay.HamsterPOS_demo.model.Product;
import com.bahaaay.HamsterPOS_demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private ProductService productService;
    @GetMapping("/low-stock")
    public ResponseEntity<List<Product>> getLowStock()
    {
        List<Product> lowStockProducts = productService.getLowStock();

        return new ResponseEntity<>(lowStockProducts, HttpStatus.OK);
    }
}
