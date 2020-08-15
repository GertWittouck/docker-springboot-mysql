package com.gwi.transactionmanagement.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gwi.transactionmanagement.exceptions.InvalidTransactionReferenceException;
import com.gwi.transactionmanagement.model.Transaction;
import com.gwi.transactionmanagement.service.TransactionService;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/create")
    public Long createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return savedTransaction.getTransactionId();
    }

    @GetMapping("/viewAll")
    public Iterable<Transaction> viewAllTransactions() {
        return transactionService.getTransactionHistory();
    }

    @GetMapping("/view/{id}")
    public Transaction viewTransactionById(@PathVariable ("id") Long id) {
        Optional<Transaction> transaction = transactionService.getTransaction(id);
        if(transaction.isPresent()) {
            return transaction.get();
        }

        throw new InvalidTransactionReferenceException("Invalid transaction reference provided");
    }
}
