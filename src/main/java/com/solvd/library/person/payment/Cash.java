package com.solvd.library.person.payment;

public class Cash implements IPay {
    private int discount;

    public Cash(int discount) {
        this.discount = discount;
    }

    @Override
    public int pay(int cost) {
        return cost - discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
