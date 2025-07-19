package com.ecom.ProductCatlog.config;

import com.ecom.ProductCatlog.Repo.CategoriRepo;
import com.ecom.ProductCatlog.Repo.ProductRepo;
import com.ecom.ProductCatlog.model.Category;
import com.ecom.ProductCatlog.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

     private final ProductRepo productRepo;
     private final CategoriRepo categoriRepo;

    public DataSeeder(ProductRepo productRepo, CategoriRepo categoriRepo) {
        this.productRepo = productRepo;
        this.categoriRepo = categoriRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // clear All existing data
        productRepo.deleteAll();
        categoriRepo.deleteAll();

        // crete category
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("clothing");

        Category home = new Category();
        home.setName("home and kitchen");

        categoriRepo.saveAll(Arrays.asList(electronics , home , clothing));

        //Create products

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest Model Smartphone with Amazing Features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-performance laptop for work and play");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(1000.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Worm and cozy jacket for winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(129.99);
        jacket.setCategory(clothing);

        Product blender = new Product();
        blender.setName("Winter Jacket");
        blender.setDescription("High-speeed blender for smothings and more");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(89.99);
        blender.setCategory(home);

        productRepo.saveAll(Arrays.asList(phone , laptop , blender , jacket));

    }
}
