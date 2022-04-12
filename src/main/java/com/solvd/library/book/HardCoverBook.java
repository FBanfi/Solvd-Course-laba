package com.solvd.library.book;

import com.solvd.library.person.Author;

public class HardCoverBook extends Book {
    private int cmsOfCover;

    public HardCoverBook(String name, int pages, Author author, String description, TypeOfBook type, int cmsOfCover, int cost) {
        super(name, pages, author, description, type, cost);
        this.cmsOfCover = cmsOfCover;
    }

    @Override
    public void calculateCost() {
        setCost(this.getPages() + cmsOfCover * this.getAuthor().getAwards());
    }

    public void calculateCost(int discount) {
        setCost(this.getPages() - discount + cmsOfCover * this.getAuthor().getAwards());
    }
}
