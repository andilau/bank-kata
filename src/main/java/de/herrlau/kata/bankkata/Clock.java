package de.herrlau.kata.bankkata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {

    public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";

    public String dateAsString() {
        return today().format(DateTimeFormatter.ofPattern(FORMAT_DD_MM_YYYY));
    }

    protected LocalDate today() {
        return LocalDate.now();
    }
}
