package com.example.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private    Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}
