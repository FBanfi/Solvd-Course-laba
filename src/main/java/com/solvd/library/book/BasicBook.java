package com.solvd.library.book;

import com.solvd.library.person.Author;

public class BasicBook extends Book {

    public BasicBook(String name, int pages, Author author, String topic, TypeOfBook type, int cost) {
        super(name, pages, author, topic, type, cost);
    }

    @Override
    public void calculateCost() {
        setCost(this.getPages() + this.getAuthor().getAwards());
    }
}
