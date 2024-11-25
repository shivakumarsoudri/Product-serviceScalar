//package com.example.productservice.controllers;
//
//import com.example.productservice.models.Product;
//import com.example.productservice.services.FakeStoreProductService;
////import com.example.productservice.services.ProductService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CategoryController {
//
//
//     FakeStoreProductService fakeStoreProductService;
//     public CategoryController(FakeStoreProductService fakeStoreProductService) {
//         this.fakeStoreProductService=fakeStoreProductService;
//     }
//
//    @GetMapping("/Products/{id}")
//
//    public Product getByCategory(@PathVariable("id") Long id){
//        return fakeStoreProductService.getByCategory(id);
//    }
//
//}
