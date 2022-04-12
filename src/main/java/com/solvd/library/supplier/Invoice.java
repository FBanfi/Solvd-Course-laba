package com.solvd.library.supplier;

import com.solvd.library.exception.ExceptionSupplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

//I use generics here because I dont know what type of collection it will be, if it will be ordered or not, etc
public class Invoice<E> implements IPrintReceipt<Invoice> {
    private static Logger LOGGER = LogManager.getLogger(Invoice.class);
    private LocalDate maxPaymentPeriod;
    private Boolean isPaid;
    private int cost;
    private E books;

    public Invoice(LocalDate maxPaymentPeriod, Boolean isPaid, int cost, E books) {
        this.maxPaymentPeriod = maxPaymentPeriod;
        this.isPaid = isPaid;
        this.cost = cost;
        this.books = books;
    }

    @Override
    public Invoice printReceipt() {
        if (isPaid && LocalDate.now().isBefore(maxPaymentPeriod))
            LOGGER.debug("You paid in time for the following books: " + books + "at this cost: " + cost);
        else
            throw new ExceptionSupplier("You did not pay in time the books you reserved");

        return this;
    }
}
