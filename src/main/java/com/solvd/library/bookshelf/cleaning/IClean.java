package com.solvd.library.bookshelf.cleaning;

import com.solvd.library.bookshelf.Bookshelf;

import java.time.LocalDate;

public interface IClean {

    void cleanBookshelf(LocalDate lastCleaning, Bookshelf bookshelf);
}
