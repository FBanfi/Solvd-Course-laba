package com.solvd.library.bookshelf;

import com.solvd.library.book.Book;
import com.solvd.library.bookshelf.cleaning.IClean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public abstract class Bookshelf {
    private static Logger LOGGER = LogManager.getLogger(Bookshelf.class); //It is optimal to have a LinkedList,
    private LinkedList<Book> booksAvailable = new LinkedList<>(); //Because there can be loads of books in a bookshelf
    private IClean locationOfBookshelf;                              //And if you
    private LocalDate lastCleaning;

    public Bookshelf(LinkedList<Book> booksAvailable, IClean locationOfBookshelf, LocalDate lastCleaning) {
        this.booksAvailable = booksAvailable;
        validateContentOfBooks();
        this.locationOfBookshelf = locationOfBookshelf;
        this.lastCleaning = lastCleaning;
    }

    public Bookshelf() {
    }

    private int searchInLinkedList(Book book) {
        int ans = -1;

        // Traversing through the Linked List
        for (int i = 0; i < booksAvailable.size(); i++) {

            // Eztracting each element in
            // the Linked List
            Book llElement = booksAvailable.get(i);

            // Checking if the extracted element is equal to
            // the element to be searched
            if (llElement == book) {

                // Assigning the index of the
                // element to answer
                ans = i;
                break;
            }
        }
        // Checking if the element is present in the Linked
        // List
        if (ans == -1) {
            LOGGER.error("Element not found");
        } else {
            LOGGER.info("Element found in Linked List at " + ans);
        }

        return ans;
    }

    public void cleanBookshelf() {
        locationOfBookshelf.cleanBookshelf(this.getLastCleaning(), this);
    }

    public abstract void validateContentOfBooks();

    public List<Book> getBooksAvailable() {
        return booksAvailable;
    }

    public LocalDate getLastCleaning() {
        return lastCleaning;
    }

    public void setLastCleaning(LocalDate lastCleaning) {
        this.lastCleaning = lastCleaning;
    }

    public void addBookToBookshelf(Book newBook) {
        booksAvailable.add(newBook);
    }
}
