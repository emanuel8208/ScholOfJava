package com.example.demo.service;

import com.example.demo.controller.Card;
import com.example.demo.repozitory.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Service
public class CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardService (CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    @PostMapping(path = "/add/card")
    public void addCard (Card card, HttpServletResponse servletResponse) {

    }
}
