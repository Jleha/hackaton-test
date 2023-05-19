package com.hroza.hackaton_test.service;

import com.hroza.hackaton_test.entity.Transaction;
import com.hroza.hackaton_test.entity.User;
import com.hroza.hackaton_test.report.FinancialReport;
import com.hroza.hackaton_test.request.TransactionCreateRequest;

import java.util.List;

public interface TransactionService {

    public void createTransaction(TransactionCreateRequest request);

    public List<Transaction> getAllTransactionsByUser(User user);

    public FinancialReport getFinancialReport(User user);
}
