package com.hroza.hackaton_test.repo;

import com.hroza.hackaton_test.entity.Transaction;
import com.hroza.hackaton_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
