package com.example.demo.service;


import com.example.demo.controller.BankAccount;
import com.example.demo.repozitory.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @PostMapping(path = "/add/account")
    public void addBankAccount (BankAccount bankAccount, HttpServletResponse servletResponse) {
        if (bankAccount.getBalance() > 50) {
            bankAccountRepository.addBankAccount(bankAccount);
        } else {
            servletResponse.setStatus(403);
;        }
    }

    // Service , repository si controller pentru Card
    // metide -POST , GET - addCard , getCards
}
