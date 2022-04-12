package com.solvd.library.bookshelf.cleaning;

import com.solvd.library.bookshelf.Bookshelf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class HighAltitude implements IClean {
    private static Logger LOGGER = LogManager.getLogger(HighAltitude.class);

    @Override
    public void cleanBookshelf(LocalDate lastCleaning, Bookshelf bookshelf) {
        if (lastCleaning.getDayOfYear() < LocalDate.now().getDayOfYear())
            LOGGER.warn("Time to clean, ask maintenance guy for help");
        bookshelf.setLastCleaning(LocalDate.now());
    }
}
