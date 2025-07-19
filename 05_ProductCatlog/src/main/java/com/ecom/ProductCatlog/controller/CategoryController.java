package com.ecom.ProductCatlog.controller;

import com.ecom.ProductCatlog.model.Category;
import com.ecom.ProductCatlog.service.CategoriesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")

public class CategoryController {
    private CategoriesService categoriesService;

    public CategoryController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }
    @GetMapping
    public List<Category> getAllCategories(){
   return categoriesService.getAllCategories();
 }

}
