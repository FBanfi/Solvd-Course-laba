package com.solvd.library.person;

import com.solvd.library.book.Book;
import com.solvd.library.person.document.Document;

import java.util.List;

public abstract class Person {
    private String name;
    private int age;
    private String address;
    private Boolean isLibrarian;
    private Document document;

    public Person(String name, int age,String address, Boolean isLibrarian, Document document) {
        this.name = name;
        this.address = address;
        this.isLibrarian = isLibrarian;
        this.document = document;
        this.age = age;
    }

    public Person() {
    }

    public abstract List<Book> findInformation(String topic);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getLibrarian() {
        return isLibrarian;
    }

    public void setLibrarian(Boolean librarian) {
        isLibrarian = librarian;
    }

    public Document getDocumento() {
        return document;
    }

    public void setDocumento(Document document) {
        this.document = document;
    }

    public int getAge() { return age; }
}
