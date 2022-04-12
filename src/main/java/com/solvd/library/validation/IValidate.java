package com.solvd.library.validation;

import com.solvd.library.book.TypeOfBook;
import com.solvd.library.exception.ExceptionBookRequest;
import com.solvd.library.person.Author;

public interface IValidate {

    void validate(String name, TypeOfBook preference, int pages, Author author) throws ExceptionBookRequest;
}
