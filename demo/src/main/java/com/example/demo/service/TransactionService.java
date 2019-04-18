package com.example.demo.service;

import com.example.demo.controller.Transaction;
import com.example.demo.repozitory.CardRepository;
import com.example.demo.repozitory.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private CardRepository cardRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CardRepository cardRepository) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
    }

    @GetMapping(path = "/get/transaction/{index}")
    public ResponseEntity<Transaction> getTransaction (@PathVariable int index) {
        if(index < transactionRepository.getTransactions().size()) {
            Transaction ref = transactionRepository.getTransactions().get(index);
            return new ResponseEntity<Transaction>(ref, HttpStatus.OK);
        }
        return null;
    }

    @PostMapping(path = "/add/transaction")
    public void addTransaction (@RequestBody Transaction transaction) {
        int cardsSize = cardRepository.getCards().size();
        int firstCardIndex = transaction.getFirstCardIndex();
        int secondCardIndex = transaction.getSecondCardIndex();
        boolean fromFirst = transaction.isFromFirstCard();
        double amount = transaction.getAmount();

        if (firstCardIndex < cardsSize && secondCardIndex < cardsSize && firstCardIndex != secondCardIndex) {
            double firstBalance = cardRepository.getCards().get(firstCardIndex).getBalance();
            double secondBalance = cardRepository.getCards().get(secondCardIndex).getBalance();
            if (fromFirst) {
                if (firstBalance - amount > 0) {
                    cardRepository.getCards().get(firstCardIndex).setBalance(firstBalance - amount);
                    cardRepository.getCards().get(secondCardIndex).setBalance(secondBalance + amount);
                    transaction.setSuccess(true);
                } else {
                    transaction.setSuccess(false);
                }
            } else {
                if (secondBalance - amount > 0) {
                    cardRepository.getCards().get(secondCardIndex).setBalance(secondBalance - amount);
                    cardRepository.getCards().get(firstCardIndex).setBalance(firstBalance + amount);
                    transaction.setSuccess(true);
                } else {
                    transaction.setSuccess(false);
                }
            }
        } else {
            transaction.setSuccess(false);
        }
        transactionRepository.addTransaction(transaction);
    }
    @PutMapping(path = "update/transaction/{index}")
    public ResponseEntity<String> putTransaction (@PathVariable int index, @RequestBody Transaction transaction) {
        if (index < transactionRepository.getTransactions().size()) {
            transactionRepository.getTransactions().set(index, transaction);
            return new ResponseEntity<String>("Transaction updated", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Transaction was not updated",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping(path = "/delete/transaction/{index}")
    public ResponseEntity<String> deleteTransaction (@PathVariable int index) {
        if (index < transactionRepository.getTransactions().size()) {
            transactionRepository.deleteTransaction(index);
            return new ResponseEntity<String>("Transaction deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Transaction was not deleted!",HttpStatus.BAD_REQUEST);
    }
}
