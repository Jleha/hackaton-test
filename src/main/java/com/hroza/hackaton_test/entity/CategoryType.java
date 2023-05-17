package com.hroza.hackaton_test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoryType {
    INCOME("Income"),
    EXPENSE("Expense"),
    CREDIT("Credit"),
    DEPOSIT("Deposit");

    private final String displayName;

}