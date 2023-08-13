package com.jwd39.LibraryManagement.helpers;

public class DateHelper {
    public static java.sql.Date sqlDate(java.util.Date calendarDate) {
        if (calendarDate != null) {
            return new java.sql.Date(calendarDate.getTime());
        } else {
            return null;
        }

    }
}
