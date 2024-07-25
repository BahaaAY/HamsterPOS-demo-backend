package com.bahaaay.HamsterPOS_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    @Min(value = 0, message = "Price should be a positive number")
    private Double price;

    @Column(name = "quantity")
    @Min(value = 0, message = "Quantity cannot be less than 0")
    private Integer quantity;

}
