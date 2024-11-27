package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("dataBaseProductServices")
public class DataBaseproductServices implements ProductService{

     private ProductRepository productRepository;
     private CategoryRepository categoryRepository;

    public DataBaseproductServices(ProductRepository productRepository,CategoryRepository categoryRepository)
    {
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;

    }
    @Override
    //@Primary
    public Product getProductDetails(Long id) throws ProductNotFoundException {
      Optional<Product> productOptionalromDb= productRepository.findById(id);
      if(productOptionalromDb.isEmpty())
      {
          System.out.println("Product not found");
          return null;

      }
      Product productFromDb=productOptionalromDb.get();
      System.out.println(productFromDb.getTitle());
      return productFromDb;
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String categoryName) {
        Product product =new Product();
        {
                 product.setTitle(title);
                 product.setDescription(description);
                 product.setPrice(price);
                 product.setImageUrl(image);
        }
        Category categoryFromDatabase=categoryRepository.findByName(categoryName);
        if(categoryFromDatabase==null) {
            Category category =new Category();
            category.setName(categoryName);
            categoryFromDatabase=category;
            //categoryFromDatabase=categoryRepository.save(category);
        }
        product.setCategory(categoryFromDatabase);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
