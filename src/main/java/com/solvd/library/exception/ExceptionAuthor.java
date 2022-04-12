package com.solvd.library.exception;

//It is runtime exception because it is not related to some data or information but yes for some logic of my aplication
public class ExceptionAuthor extends RuntimeException {
    public ExceptionAuthor(String message) {
        super(message);
    }
}
