package com.solvd.library.bookshelf.cleaning;

import com.solvd.library.bookshelf.Bookshelf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class MediumAltitud implements IClean {
    private static Logger LOGGER = LogManager.getLogger(MediumAltitud.class);

    @Override
    public void cleanBookshelf(LocalDate lastCleaning, Bookshelf bookshelf) {
        if (lastCleaning.getDayOfMonth() < LocalDate.now().getDayOfMonth()) {
            LOGGER.warn("Use the stairs to clean!");
            bookshelf.setLastCleaning(LocalDate.now());
        }
    }
}
