package com.springboot.models.entity;

import javax.persistence.*;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price = 0.0; // default value set to 0.0

    // constructors, getters, and setters
    // ...
}
