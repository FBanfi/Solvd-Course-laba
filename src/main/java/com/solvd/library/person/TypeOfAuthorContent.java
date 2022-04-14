package com.solvd.library.person;

public enum TypeOfAuthorContent {
    ADULT(18),
    CHILD(14);

    private int age;

    TypeOfAuthorContent(int age) {
        this.age = age;
    }

    public int getMinimunAge() {
        return this.age;
    }
}
