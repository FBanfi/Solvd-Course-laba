package com.solvd.library.bookshelf;

import com.solvd.library.book.Book;
import com.solvd.library.bookshelf.cleaning.IClean;
import com.solvd.library.exception.ExceptionBookshelf;

import java.time.LocalDate;
import java.util.LinkedList;

public class ChildBookshelf extends Bookshelf {
    public ChildBookshelf(LinkedList<Book> booksAvailable, IClean locationOfBookshelf, LocalDate lastCleaning) {
        super(booksAvailable, locationOfBookshelf, lastCleaning);
    }

    public ChildBookshelf() {
        super();
    }

    @Override
    public void validateContentOfBooks() {
        if (getBooksAvailable().stream().anyMatch(book -> book.getAuthor().getContent().equals("ADULT")))
            throw new ExceptionBookshelf("[WARNING] There are adult books in the child section!");
    }
}
