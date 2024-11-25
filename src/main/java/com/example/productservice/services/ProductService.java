package com.example.productservice.services;

import com.example.productservice.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public Product getProductDetails(Long id);
    public Product createProduct(String title,String description,String image,double price,String category);
    public List<Product> getAllProducts();



}
