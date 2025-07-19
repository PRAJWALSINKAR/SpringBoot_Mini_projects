package com.ecom.ProductCatlog.Repo;

import com.ecom.ProductCatlog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriRepo extends JpaRepository<Category, Long> {

}
