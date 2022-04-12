package com.solvd.library.person.payment;

public class Card implements IPay {
    private int bankInterest;

    public Card(int bankInterest) {
        this.bankInterest = bankInterest;
    }

    @Override
    public int pay(int cost) {
        return cost + bankInterest;
    }

    public int getBankInterest() {
        return bankInterest;
    }

    public void setBankInterest(int bankInterest) {
        this.bankInterest = bankInterest;
    }
}
