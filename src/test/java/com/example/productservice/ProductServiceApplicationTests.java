package com.example.productservice;

import com.example.productservice.models.Product;
import com.example.productservice.projections.ProductTitleAndDescription;
import com.example.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {

@Autowired
    private ProductRepository productRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void Test()
    {
        Optional<Product> productOptional=
                productRepository.findByTitleAndCategory_Name(
                        "iphone","phone");
        System.out.println(productOptional.get().getTitle());
    }
    @Test
    public void Test1()
    {
        List<Product> productOptional=
                productRepository.getProductData("phone");
        System.out.println(productOptional.get(0).getTitle());
    }
    @Test
    public void Test2()
    {
      Product productOptional=
                productRepository.getProduct2(1L);
        System.out.println(productOptional.getId());
    }
    @Test
    public void Test4()
    {
        ProductTitleAndDescription productOptional=
                productRepository.getProduct3(1L);
        System.out.println(productOptional.getTitle()+" "+ productOptional.getDescription());
    }



}
