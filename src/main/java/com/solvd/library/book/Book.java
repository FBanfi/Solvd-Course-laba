package com.solvd.library.book;

import com.solvd.library.exception.ExceptionBook;
import com.solvd.library.person.Author;

import java.util.List;
import java.util.Objects;

public abstract class Book {
    private String name;
    private int pages;
    private Author author;
    private String topic;
    private int cost;
    private TypeOfBook type;

    public Book(String name, int pages, Author author, String topic, TypeOfBook type, int cost) {
        this.name = name;
        this.pages = pages;
        this.author = author;
        this.topic = topic;
        this.type = type;
        this.cost = cost;

        if (validateAuthenticity())
            throw new ExceptionBook("This book is not original!!");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Book other = (Book) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (this.pages != other.pages) {
            return false;
        }

        if (this.cost != other.cost) {
            return false;
        }

        if (this.author != other.author) {
            return false;
        }

        if (this.type != other.type) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages, author, topic, cost, type);
    }

    private Boolean validateAuthenticity() {
        List<Book> books = this.author.getBooksRealesed();

        return books.stream().anyMatch(book -> book.hashCode() == this.hashCode() && book.equals(this));
    }

    public abstract void calculateCost();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public TypeOfBook getType() {
        return type;
    }

    public void setType(TypeOfBook type) {
        this.type = type;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
