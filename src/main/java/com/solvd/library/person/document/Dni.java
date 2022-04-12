package com.solvd.library.person.document;

import com.solvd.library.exception.ExceptionDocument;

public class Dni implements IValidateDocument {

    @Override
    public void validateDocument(String numero) {
        if (numero.length() != 8) {
            throw new ExceptionDocument("The Dni entered is not valid");
        }
    }
}
