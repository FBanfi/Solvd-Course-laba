package com.solvd.library.bookshelf.cleaning;

import com.solvd.library.bookshelf.Bookshelf;

import java.time.LocalDate;

public class LowAltitude implements IClean {

    @Override
    public void cleanBookshelf(LocalDate lastCleaning, Bookshelf bookshelf) {
        if (lastCleaning.getDayOfMonth() < LocalDate.now().getDayOfMonth() && lastCleaning.getDayOfWeek().equals(LocalDate.now().getDayOfWeek()))
            bookshelf.setLastCleaning(LocalDate.now());
    }
}
