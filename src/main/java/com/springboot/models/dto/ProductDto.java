package com.springboot.models.dto;

public class ProductDto {
    private Long id;
    private String Name;
    private Double price;

    public ProductDto() {
        // Default constructor
    }

    public ProductDto(String name) {
        this.Name = name;
    }

    public ProductDto(Double price) {
        this.price = price;
    }

    public ProductDto(Long id, String name, Double price) {
        this.id = id;
        this.Name = name;
        this.price = price;
    }

    public Long getId() {
        return null;
    }

    // Getters and setters omitted for brevity
}

