package com.bahaaay.HamsterPOS_demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.lang.model.element.Name;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "price")
    @NotNull
    @Min(value = 0, message = "Price should be a positive number")
    private Double price;

    @Column(name = "quantity")
    @NotNull
    @Min(value = 0, message = "Quantity cannot be less than 0")
    private Integer quantity;

    @Column(name = "reorderLevel")
    @NotNull
    @Min(value = 0, message = "level should be greater than 0")
    private Integer reorderLevel;

}
