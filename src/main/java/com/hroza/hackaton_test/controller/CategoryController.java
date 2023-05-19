package com.hroza.hackaton_test.controller;

import com.hroza.hackaton_test.request.CategoryCreateRequest;
import com.hroza.hackaton_test.service.CategoryService;
import com.hroza.hackaton_test.service.impl.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@RequestBody CategoryCreateRequest request) {
        categoryService.createCategory(request);
        return ResponseEntity.ok().build();
    }
}
