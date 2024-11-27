package com.example.productservice.controllers;

import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    ProductService productservice;

    public ProductController(@Qualifier("dataBaseProductServices") ProductService productservice) {
        this.productservice = productservice;
    }

    @GetMapping("/Products")
    public List<Product> getAllProducts() {
       return  productservice.getAllProducts();

    }

    @GetMapping("/Products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id) throws ProductNotFoundException {
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
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDto> handleNPEexception() {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage("something went wrong");
//        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(
//                errorDto, HttpStatusCode.valueOf(500)
//        );
//        return responseEntity;
//    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handlePNPEexception(){
//        ErrorDto errorDto =new ErrorDto();
//        errorDto.setMessage("Product Not found.please try again");
//        ResponseEntity<ErrorDto> responseEntity =new ResponseEntity<>(
//                errorDto,HttpStatusCode.valueOf(404)
//        );
//        return responseEntity;
//    }

}


