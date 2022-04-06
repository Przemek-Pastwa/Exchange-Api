package com.devopsi.akademia.exchangeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public static String getCurrentDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}
