package com.hroza.hackaton_test.service.impl;

import com.hroza.hackaton_test.entity.Category;
import com.hroza.hackaton_test.repo.CategoryRepository;
import com.hroza.hackaton_test.request.CategoryCreateRequest;
import com.hroza.hackaton_test.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(CategoryCreateRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setType(request.getType());
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
