package com.hitms.lms;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LibraryService {

    private static final int LOAN_DAYS = 14;
    private static final int FINE_PER_DAY = 10;

    private final Set<String> books = new HashSet<>();
    private final Map<String, LocalDate> issuedBooks = new HashMap<>();

    private String normalize(String title) {
        return title.trim().toLowerCase();
    }

    public boolean addBook(String title) {
        return books.add(normalize(title));
    }

    public int bookCount() {
        return books.size();
    }

    public boolean issueBook(String title, LocalDate issueDate) {
        String key = normalize(title);
        if (issuedBooks.containsKey(key)) {
            return false;
        }
        issuedBooks.put(key, issueDate);
        return true;
    }
   /**
     * Adds a book to the library. Returns false if it already exists.
     */
    public boolean isAvailable(String title) {
        return !issuedBooks.containsKey(normalize(title));
    }

    public long returnBook(String title, LocalDate returnDate) {
        String key = normalize(title);
        LocalDate issueDate = issuedBooks.remove(key);
        if (issueDate == null) {
            return 0;
        }
        long daysKept = ChronoUnit.DAYS.between(issueDate, returnDate);
        long lateDays = Math.max(0, daysKept - LOAN_DAYS);
        return lateDays * FINE_PER_DAY;
    }
        public boolean hasBook(String title) {
        return books.contains(normalize(title));
    }
}