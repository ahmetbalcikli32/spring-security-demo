package com.ahmetbalcikli.springSecurityDemo.category;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {

    private static List<Category> categories = Arrays.asList(
            new Category(1, "Cep Telefonu"),
            new Category(2, "Bilgisayar"),
            new Category(3, "Beyaz Eşya"),
            new Category(4, "Televizyon")
    );

//    @GetMapping(path = "/{id}")
    @PreAuthorize("hasRole(ROLE_ADMIN)")
    public Category getCategory(@PathVariable Integer id) {
        return categories.stream().filter(category -> id.equals(category.getId()))
                .findFirst().orElseThrow(() -> new IllegalStateException("Kategori " + id + " mevcut değil"));
    }

    @GetMapping()
    public List<Category> getAllCategories(){
        return categories;
    }
}
