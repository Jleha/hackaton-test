package com.hroza.hackaton_test.request;

import com.hroza.hackaton_test.entity.Category;
import com.hroza.hackaton_test.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TransactionCreateRequest {
    private User user;
    private BigDecimal amount;
    private LocalDate date;
    private Category category;

}
