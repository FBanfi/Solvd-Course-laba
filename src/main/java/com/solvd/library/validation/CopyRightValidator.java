package com.solvd.library.validation;

import com.solvd.library.book.Book;
import com.solvd.library.book.TypeOfBook;
import com.solvd.library.exception.ExceptionAuthor;
import com.solvd.library.person.Author;

import java.util.List;

public class CopyRightValidator implements IValidate {

    @Override
    public void validate(String name, TypeOfBook preference, int pages, Author author) {
        List<Book> booksOfThatAuthor = author.getBooksRealesed();
        for (Book book : booksOfThatAuthor) {
            if (!booksOfThatAuthor.contains(book))
                throw new ExceptionAuthor("This author is not the creator of that book!!! :S");
        }
    }
}
