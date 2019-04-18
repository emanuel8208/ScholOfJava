package com.example.demo.repozitory;

import com.example.demo.controller.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Repository
public class TransactionRepository {

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public void addTransaction (Transaction transaction) { transactions.add(transaction);}

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public void deleteTransaction (int index) {
        transactions.remove(index);
    }
}
