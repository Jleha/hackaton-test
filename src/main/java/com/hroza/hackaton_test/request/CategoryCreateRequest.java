package com.hroza.hackaton_test.request;

import com.hroza.hackaton_test.entity.CategoryType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryCreateRequest {
    private String name;
    private String description;
    private CategoryType type;

}
