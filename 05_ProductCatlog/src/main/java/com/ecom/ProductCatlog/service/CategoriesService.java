package com.ecom.ProductCatlog.service;

import com.ecom.ProductCatlog.Repo.CategoriRepo;
import com.ecom.ProductCatlog.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
     private final CategoriRepo categoriRepo;

    @Autowired
    public CategoriesService(CategoriRepo categoriRepo) {
        this.categoriRepo = categoriRepo;
    }

     public List<Category> getAllCategories() {
         return categoriRepo.findAll();
     }
}
