package com.example.productservice.services;
import com.example.productservice.dtos.CreateProductRequestDto;
import com.example.productservice.dtos.FakeStoreCreateProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public  class  FakeStoreProductService implements ProductService{
private  RestTemplate restTemplate;
public FakeStoreProductService(RestTemplate restTemplate){
this.restTemplate=restTemplate;
}

    @Override
 public Product getProductDetails(Long id) {
//        FakeStoreProductDto responseDto =
//                restTemplate.getForObject(
//                        "https://fakestoreapi.com/products/1" + id,
//                        FakeStoreProductDto.class);
//        return responseDto.toProduct();}

                 ResponseEntity<FakeStoreProductDto> responseEntity=restTemplate.getForEntity(
                          "https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class);
                 if(responseEntity.getStatusCode()== HttpStatusCode.valueOf(404))
                 {  }
                     else if(responseEntity.getStatusCode()== HttpStatusCode.valueOf(500))
                     { }
                         return responseEntity.getBody().toProduct();
    }


        @Override
        public Product createProduct(String title,String description, String image,double price, String category){
            FakeStoreCreateProductDto requestDto = new FakeStoreCreateProductDto();
            requestDto.setTitle(title);
            requestDto.setDescription(description);
            requestDto.setImage(image);
            requestDto.setPrice(price);
            requestDto.setCategory(category);

            FakeStoreProductDto responseDto =
                    restTemplate.postForObject(
                            "https://fakestoreapi.com/products", requestDto, FakeStoreProductDto.class);
            return responseDto.toProduct();
        }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] responseDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> products=new ArrayList<>();
        for(FakeStoreProductDto dto:responseDto){
            products.add(dto.toProduct());
        }
        return products;
    }
}

//public  Product getByCategory(Long id){
//    FakeStoreProductDto responseDto=
//            restTemplate.getForObject
//                    ("https://fakestoreapi.com/products /"+id,FakeStoreProductDto.class);
//    Product  product =new Product();
//    product.setId(responseDto.getId());
//    product.setTitle(responseDto.getTitle());
//    product.setDescription(responseDto.getDescription());
//    product.setPrice(Double.parseDouble(responseDto.getPrice()));
//    product.setImageUrl(responseDto.getImage());
//    Category category =new Category();
//    category.setName(responseDto.getCategory());
//    product.setCategory(category);
//    return product;
//
//}


