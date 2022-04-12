package com.solvd.library.person.document;

import com.solvd.library.exception.ExceptionDocument;

public class Passport implements IValidateDocument {

    @Override
    public void validateDocument(String numero) {
        if (numero.length() != 9) {
            throw new ExceptionDocument("The passport digits are not valid");
        }
    }
}
