package com.example.demo.controller;

import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/add/transaction")
    public void addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }

    @GetMapping(path = "/get/transaction/{index}")
    public ResponseEntity<Transaction> getTransaction (@PathVariable int index) {
        return transactionService.getTransaction(index);
    }

    @PutMapping(path = "update/transaction/{index}")
    public ResponseEntity<String> putTransaction (@PathVariable int index, @RequestBody Transaction transaction) {
        return transactionService.putTransaction(index, transaction);
    }
    @DeleteMapping(path = "/delete/transaction/{index}")
    public ResponseEntity<String> deleteTransaction (@PathVariable int index) {
        return transactionService.deleteTransaction(index);
    }
}
