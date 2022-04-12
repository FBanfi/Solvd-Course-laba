package com.solvd.library.bookshelf;

import com.solvd.library.book.Book;
import com.solvd.library.bookshelf.cleaning.IClean;
import com.solvd.library.exception.ExceptionBookshelf;

import java.time.LocalDate;
import java.util.LinkedList;

public class AdultBookshelf extends Bookshelf {

    public AdultBookshelf(LinkedList<Book> booksAvailable, IClean locationOfBookshelf, LocalDate lastCleaning) {
        super(booksAvailable, locationOfBookshelf, lastCleaning);
    }

    public AdultBookshelf() {
        super();
    }

    @Override
    public void validateContentOfBooks() {
        if (getBooksAvailable().stream().anyMatch(book -> book.getAuthor().getContent().equals("CHILD")))
            throw new ExceptionBookshelf("[WARNING] There are child books in the adult section!");
    }
}
