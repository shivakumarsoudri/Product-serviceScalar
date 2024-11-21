package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    ProductService productservice;

    public ProductController(ProductService productservice)
    {
        this.productservice=productservice;
    }

@GetMapping("/Products")
    public void getAllProducts(){

    }
 @GetMapping("/Products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){
    productservice.getProductDetails(id);

      return null;
    }
    public void createProduct()
    {

    }
}
