package com.hroza.hackaton_test.service;

import com.hroza.hackaton_test.entity.Category;
import com.hroza.hackaton_test.request.CategoryCreateRequest;

import java.util.List;

public interface CategoryService {

    public void createCategory(CategoryCreateRequest request);

    public List<Category> getAllCategories();
}
