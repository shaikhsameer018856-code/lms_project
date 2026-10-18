package com.hitms.lms.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryUtils {

    public static String formatTitle(String title) {
        String trimmed = title.trim().toLowerCase();
        String[] words = trimmed.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String w : words) {
            result.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1))
                    .append(" ");
        }

        return result.toString().trim();
    }

    public static long daysBetween(LocalDate date1, LocalDate date2) {
        return Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }
}