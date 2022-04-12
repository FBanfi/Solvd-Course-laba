package com.solvd.library.bookRequest;

import com.solvd.library.book.TypeOfBook;
import com.solvd.library.bookRequest.Mail.IMail;
import com.solvd.library.exception.ExceptionBookRequest;
import com.solvd.library.person.Author;
import com.solvd.library.person.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OnlineRequest extends BookRequest {
    private static Logger LOGGER = LogManager.getLogger(OnlineRequest.class);
    private IMail mailApp;

    public OnlineRequest(String name, Client client, TypeOfBook preference, int pages, Author author) throws ExceptionBookRequest {
        super(name, client, preference, pages, author);
    }

    public OnlineRequest(String topic) {
        super(topic);
    }

    @Override
    public void notifyTimeOfTheRequest() {
        LOGGER.debug("You will receive an email when the librarian find your book and you can come to get it!");
        mailApp.sendMail(getClient());
    }
}
