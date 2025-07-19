package com.ecom.ProductCatlog.controller;

import com.ecom.ProductCatlog.model.Product;
import com.ecom.ProductCatlog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

     private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
     @GetMapping
    public List<Product> getAllProduct(){
        return  productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getAllProductByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }
}
