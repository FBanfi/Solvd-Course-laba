package com.solvd.library.book;

import com.solvd.library.exception.ExceptionBook;
import com.solvd.library.person.Author;

public class EspecialEditionBook extends Book {
    private String thematic;
    private int additionalCost;

    public EspecialEditionBook(String name, int pages, Author author, String description, TypeOfBook type, String thematic, int cost, int additionalCost) {
        super(name, pages, author, description, type, cost);
        this.thematic = thematic;
        this.additionalCost = additionalCost;
    }

    @Override
    public void calculateCost() {
        setCost(this.getPages() * this.getAuthor().getAwards() + additionalCost);
    }
}
