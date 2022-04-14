package com.solvd.library.person;


import com.solvd.library.book.Book;
import com.solvd.library.book.TypeOfBook;
import com.solvd.library.bookRequest.BookRequest;
import com.solvd.library.bookRequest.OnlineRequest;
import com.solvd.library.bookRequest.PresencialRequest;
import com.solvd.library.functionalInterfaces.IRead;
import com.solvd.library.functionalInterfaces.ISell;
import com.solvd.library.person.document.Document;
import com.solvd.library.person.payment.IPay;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Stack;

public class Client extends Person {
    private static Logger LOGGER = LogManager.getLogger(Client.class);
    private Stack<Book> ownedBooks;
    private Stack<Book> borrowedBooks;
    private Boolean onlineClient;
    private int money;
    private IPay payMethod;

    public Client(String name, int age, String address, Boolean isLibrarian, Document document, Stack<Book> ownedBooks, Stack<Book> borrowedBooks, Boolean onlineClient, int money, IPay payMethod) {
        super(name, age, address, isLibrarian, document);
        this.ownedBooks = ownedBooks;
        this.borrowedBooks = borrowedBooks;
        this.onlineClient = onlineClient;
        this.money = money;
        this.payMethod = payMethod;
    }

    public void buyBook(Book randomBook) {
        randomBook.calculateCost();
        setMoney(money - payMethod.pay(randomBook.getCost()));
        ownedBooks.add(randomBook);
    }

    public void readBook(IRead reader) {
        reader.read();
    }

    public void sellBook(ISell seller, Book book) {
        seller.sell(book);
    }

    @Override
    public List<Book> findInformation(String topic) { //tell the librarian to find it
        return Librarian.instance().findTopicInBookshelfs(topic);
    }

    public Book findBook(String name, TypeOfBook preference, int pages, Author author) {
        BookRequest bookRequest;
        if (onlineClient == true)
            bookRequest = new OnlineRequest(name, this, preference, pages, author);
        else
            bookRequest = new PresencialRequest(name, this, preference, pages, author);

        Book wantedBook = Librarian.instance().findInBookShelf(bookRequest, this);
        verifyOwnedBooks(wantedBook);
        verifyBorrowedBooks(wantedBook);
        return wantedBook;
    }

    private Book verifyOwnedBooks(Book otherBook) {
        if (ownedBooks.contains(otherBook))
            LOGGER.warn("You already have this book");
        return otherBook;
    }

    private Book verifyBorrowedBooks(Book otherBook) {
        if (borrowedBooks.contains(otherBook))
            LOGGER.debug("You are borrowing this book");
        return otherBook;
    }

    public List<Book> getOwnedBooks() {
        return ownedBooks;
    }

    public void addToOwnedBooks(Book newBook) {
        this.ownedBooks.add(newBook);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Stack<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
