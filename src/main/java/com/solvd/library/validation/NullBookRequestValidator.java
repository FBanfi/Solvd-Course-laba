package com.solvd.library.validation;

import com.solvd.library.book.TypeOfBook;
import com.solvd.library.exception.ExceptionBookRequest;
import com.solvd.library.person.Author;

public class NullBookRequestValidator implements IValidate {

    @Override
    public void validate(String name, TypeOfBook preference, int pages, Author author) throws ExceptionBookRequest {
        if (name == null || preference == null || pages == 0 || author == null)
            throw new ExceptionBookRequest("You have to complete the value of the attributes");
    }
}
