package com.hroza.hackaton_test.service.impl;

import com.hroza.hackaton_test.entity.CategoryType;
import com.hroza.hackaton_test.entity.Transaction;
import com.hroza.hackaton_test.entity.User;
import com.hroza.hackaton_test.repo.TransactionRepository;
import com.hroza.hackaton_test.report.FinancialReport;
import com.hroza.hackaton_test.request.TransactionCreateRequest;
import com.hroza.hackaton_test.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(TransactionCreateRequest request) {
        Transaction transaction = new Transaction();
        transaction.setUser(request.getUser());
        transaction.setAmount(request.getAmount());
        transaction.setDate(request.getDate());
        transaction.setCategory(request.getCategory());
        transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    public FinancialReport getFinancialReport(User user) {
        List<Transaction> userTransactions = transactionRepository.findByUser(user);

        BigDecimal totalBalance = BigDecimal.ZERO;
        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal totalExpense = BigDecimal.ZERO;
        BigDecimal totalCredit = BigDecimal.ZERO;
        BigDecimal totalDeposit = BigDecimal.ZERO;

        for (Transaction transaction : userTransactions) {
            BigDecimal amount = transaction.getAmount();
            CategoryType categoryType = transaction.getCategory().getType();

            totalBalance = totalBalance.add(amount);

            if (categoryType == CategoryType.INCOME) {
                totalIncome = totalIncome.add(amount);
            } else if (categoryType == CategoryType.EXPENSE) {
                totalExpense = totalExpense.add(amount);
            } else if (categoryType == CategoryType.CREDIT) {
                totalCredit = totalCredit.add(amount);
            } else if (categoryType == CategoryType.DEPOSIT) {
                totalDeposit = totalDeposit.add(amount);
            }
        }

        FinancialReport report = new FinancialReport();
        report.setTotalBalance(totalBalance);
        report.setTotalIncome(totalIncome);
        report.setTotalExpense(totalExpense);
        report.setTotalCredit(totalCredit);
        report.setTotalDeposit(totalDeposit);
        return report;
    }
}
