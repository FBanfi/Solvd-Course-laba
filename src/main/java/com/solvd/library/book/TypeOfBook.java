package com.solvd.library.book;

public enum TypeOfBook {
    HISTORICAL("Historical"),
    THRILLER("Thriller"),
    HORROR("Horror"),
    DRAMA("Drama"),
    SCIENCE_FICTION("Science Fiction"),
    ROMANCE("Romance"),
    FANTASY("Fantasy"),
    COMEDY("Comedy");

    private String value;

    TypeOfBook (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
