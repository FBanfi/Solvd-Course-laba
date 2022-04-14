package com.solvd.library.bookRequest;

import com.solvd.library.book.TypeOfBook;
import com.solvd.library.person.Author;
import com.solvd.library.person.Client;
import com.solvd.library.validation.CopyRightValidator;
import com.solvd.library.validation.IValidate;
import com.solvd.library.validation.NullBookRequestValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class BookRequest {
    private static Logger LOGGER = LogManager.getLogger(BookRequest.class);
    private Client client;
    private String name;
    private TypeOfBook preference;
    private int pages;
    private Author author;
    private String topic;
    private List<IValidate> listOfValidations = new ArrayList<>();

    public BookRequest(String name, Client client, TypeOfBook preference, int pages, Author author) {
        this.name = name;
        this.client = client;
        this.preference = preference;
        this.pages = pages;
        this.author = author;

        listOfValidations.add(new CopyRightValidator());
        listOfValidations.add(new NullBookRequestValidator());

        listOfValidations.stream().forEach(validator -> validator.validate(name, preference, pages, author));
    }

    public BookRequest(String topic) {
        this.topic = topic;
    }

    public abstract void notifyTimeOfTheRequest();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfBook getPreference() {
        return preference;
    }

    public void setPreference(TypeOfBook preference) {
        this.preference = preference;
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

    public Client getClient() { return client; }
}
