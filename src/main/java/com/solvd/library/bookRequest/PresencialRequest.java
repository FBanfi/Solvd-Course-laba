package com.solvd.library.bookRequest;

import com.solvd.library.book.TypeOfBook;
import com.solvd.library.exception.ExceptionBookRequest;
import com.solvd.library.person.Author;
import com.solvd.library.person.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PresencialRequest extends BookRequest {
    private static Logger LOGGER = LogManager.getLogger(PresencialRequest.class);

    public PresencialRequest(String name, Client client, TypeOfBook preference, int pages, Author author) throws ExceptionBookRequest {
        super(name, client, preference, pages, author);
    }

    public PresencialRequest(String topic) {
        super(topic);
    }

    @Override
    public void notifyTimeOfTheRequest() {
        LOGGER.debug("The librarian will search for you book, wait 10 minutes pls!");
    }

}
