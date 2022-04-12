package com.solvd.library.person;

import com.solvd.library.book.Book;
import com.solvd.library.person.document.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Author extends Person {
    private List<Book> booksRealesed;
    private Queue<Book> bookToRealese;
    private TypeOfAuthorContent content;
    private int awards;

    public Author(String name, int age,String address, Boolean isLibrarian, Document document, List<Book> booksRealesed, Queue<Book> bookToRealese, TypeOfAuthorContent content, int awards) {
        super(name, age,address, isLibrarian, document);
        this.booksRealesed = booksRealesed;
        this.bookToRealese = bookToRealese;
        this.content = content;
        this.awards = awards;
    }

    @Override
    public List<Book> findInformation(String topic) {
        List<Book> booksOfThatTopic = new ArrayList<Book>();
        for (Book book : booksRealesed) {
            if (book.getTopic().equals(topic))
                booksOfThatTopic.add(book);
        }
        return booksOfThatTopic;
    }

    private void realeseNewBook() {
        booksRealesed.add(bookToRealese.remove());
    }

    private void writeNewBook(Book newBook) {
        bookToRealese.add(newBook);
    }

    public List<Book> getBooksRealesed() {
        return booksRealesed;
    }

    public void setBooksRealesed(List<Book> booksRealesed) {
        this.booksRealesed = booksRealesed;
    }

    public TypeOfAuthorContent getContent() {
        return content;
    }

    public void setContent(TypeOfAuthorContent content) {
        this.content = content;
    }

    public int getAwards() {
        return awards;
    }

    public void setAwards(int awards) {
        this.awards = awards;
    }

    public Queue<Book> getBookToRealese() {
        return bookToRealese;
    }

    public void setBookToRealese(Queue<Book> bookToRealese) {
        this.bookToRealese = bookToRealese;
    }
}
