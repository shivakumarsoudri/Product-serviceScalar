package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.models.Product;

import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/Products")
    public List<Product> getAllProducts() {
       return  productservice.getAllProducts();

    }

    @GetMapping("/Products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) {
        return productservice.getProductDetails(id);
    }

    @PostMapping("/Products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto) {

       Product product= productservice.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory());

        ResponseEntity<Product> responseEntity =new ResponseEntity<>(product, HttpStatusCode.valueOf(201));
      return  responseEntity;




    }
}


