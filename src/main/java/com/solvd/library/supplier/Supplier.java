package com.solvd.library.supplier;

import com.solvd.library.bookshelf.Bookshelf;
import com.solvd.library.person.Librarian;
import com.solvd.library.threads.Conection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Supplier<S> extends Thread {
    private static Logger LOGGER = LogManager.getLogger(Supplier.class);
    private Bookshelf inComingBooks;
    private IPrintReceipt<S> typeReceipt;
    private Conection conection;

    @Override
    public void run() {
        conection.getInfo();
    }

    public Supplier(Bookshelf inComingBooks, IPrintReceipt<S> typeReceipt) {
        this.inComingBooks = inComingBooks;
        this.typeReceipt = typeReceipt;
    }

    public S supplyLibrary() {
        Librarian.instance().addBookshelf(inComingBooks);
        return typeReceipt.printReceipt();
    }

    public Bookshelf getInComingBooks() {
        return inComingBooks;
    }

    public void setInComingBooks(Bookshelf inComingBooks) {
        this.inComingBooks = inComingBooks;
    }

    public Conection getConection() {
        return conection;
    }

    public void setConection(Conection conection) {
        this.conection = conection;
    }
}
