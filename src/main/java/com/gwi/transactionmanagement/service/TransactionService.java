package com.gwi.transactionmanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gwi.transactionmanagement.model.Transaction;
import com.gwi.transactionmanagement.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction) {
        // TODO: add validation to transaction object before saving
        return transactionRepository.save(transaction);
    }

    public Iterable<Transaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }
}
