package com.example.demo.service;

import com.example.demo.controller.Card;
import com.example.demo.repozitory.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class CardService {

    private CardRepository cardRepository;


    @Autowired
    public CardService (CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @PostMapping(path = "/add/card")
    public void addCard (Card card, HttpServletResponse servletResponse) {
        if((card.getName() != null) || card.getName().length() > 0) {
            cardRepository.addCard(card);
        } else {
            servletResponse.setStatus(403);
        }
    }

    @GetMapping(path = "/get/Cards")
    public ResponseEntity<List<Card>> getCards() {
        return new ResponseEntity<List<Card>>(cardRepository.getCards(), HttpStatus.OK);
    }
}
