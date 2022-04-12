package com.solvd.library.bookRequest.Mail;

import com.solvd.library.person.Client;

@FunctionalInterface
public interface IMail {
    void sendMail(Client client);
}
