package com.solvd.library.supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//I use generics here because I dont know what type of collection it will be, if it will be ordered or not, etc
public class Ticket<T> implements IPrintReceipt<Ticket> {
    private static Logger LOGGER = LogManager.getLogger(Ticket.class);
    private int cost;
    private T books;

    public Ticket(int cost, T books) {
        this.cost = cost;
        this.books = books;
    }

    @Override
    public Ticket printReceipt() {
        LOGGER.debug("You bought the following books: " + books + "at this cost: " + cost);
        return this;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public T getBooks() {
        return books;
    }

    public void setBooks(T books) {
        this.books = books;
    }
}
