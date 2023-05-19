package com.hroza.hackaton_test.controller;

import com.hroza.hackaton_test.entity.Transaction;
import com.hroza.hackaton_test.entity.User;
import com.hroza.hackaton_test.report.FinancialReport;
import com.hroza.hackaton_test.request.TransactionCreateRequest;
import com.hroza.hackaton_test.service.TransactionService;
import com.hroza.hackaton_test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService,UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionCreateRequest request) {
        transactionService.createTransaction(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getUserTransactions(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        List<Transaction> transactions = transactionService.getAllTransactionsByUser(user);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/user/{userId}/report")
    public ResponseEntity<FinancialReport> getUserFinancialReport(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        FinancialReport report = transactionService.getFinancialReport(user);
        return ResponseEntity.ok(report);
    }
}