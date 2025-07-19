package com.ecom.ProductCatlog.service;

import com.ecom.ProductCatlog.Repo.ProductRepo;
import com.ecom.ProductCatlog.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private  final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId){
        return  productRepo.findByCategoryId(categoryId);
    }
}
