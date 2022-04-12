package com.solvd.library.person.document;

import com.solvd.library.exception.ExceptionDocument;

public class Document {
    private IValidateDocument type;
    private String number;

    public Document(IValidateDocument type, String number) {
        this.type = type;
        type.validateDocument(number);
        this.number = number;
    }

    public IValidateDocument getType() {
        return type;
    }

    public void setType(IValidateDocument type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
