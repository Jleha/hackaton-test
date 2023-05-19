package com.hroza.hackaton_test.request;

import com.hroza.hackaton_test.entity.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String email;

}

