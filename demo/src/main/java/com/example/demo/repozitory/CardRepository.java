package com.example.demo.repozitory;

import com.example.demo.controller.Card;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CardRepository {

   private List<Card> cards = new ArrayList<>();

   public void addCard (Card card) {
       cards.add(card);
   }

   public List<Card> getCards() {
        return cards;
    }
}
