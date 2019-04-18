package com.example.demo.controller;

public class Transaction {

    private int firstCardIndex;
    private int secondCardIndex;
    private boolean fromFirstCard;
    private double amount;
    private boolean success = false;

    @Override
    public String toString() {
        return "Transaction{" +
                "firstCardIndex=" + firstCardIndex +
                ", secondCardIndex='" + secondCardIndex + '\'' +
                ", fromFirstCard=" + fromFirstCard +
                ", amount=" + amount +
                ", success=" + success +
                '}';
    }

    public int getFirstCardIndex() {
        return firstCardIndex;
    }

    public void setFirstCardIndex(int firstCardIndex) {
        this.firstCardIndex = firstCardIndex;
    }

    public int getSecondCardIndex() {
        return secondCardIndex;
    }

    public void setSecondCardIndex(int secondCardIndex) {
        this.secondCardIndex = secondCardIndex;
    }

    public boolean isFromFirstCard() {
        return fromFirstCard;
    }

    public void setFromFirstCard(boolean fromFirstCard) {
        this.fromFirstCard = fromFirstCard;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
