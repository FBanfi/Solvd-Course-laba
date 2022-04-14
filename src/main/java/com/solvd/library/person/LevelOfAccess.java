package com.solvd.library.person;

import java.util.Date;

public enum LevelOfAccess {
    DEPOSIT(2),
    CASH(2),
    BOOKSHELFS(4),
    CASH_AND_BOOKSHELFS(5),
    ALL_LIBRARY(6);

    private int numberOfKeys;

    LevelOfAccess(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public int getNumberOfKeys() {
        return this.numberOfKeys;
    }
}
