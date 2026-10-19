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

    /**
     * Adds a book to the library. Returns false if it already exists.
     */
    public boolean addBook(String title) {
        return books.add(normalize(title));
    }

    /**
     * Returns the total number of books in the library.
     */
    public int bookCount() {
        return books.size();
    }

       /**
     * Issues a single copy; throws BookUnavailableException if none left
     */
    
    public boolean issueBook(String title, LocalDate issueDate) {
        if (title == null || title.trim().isEmpty() || issueDate == null) {
            return false;
        }
        String key = normalize(title);
        if (issuedBooks.containsKey(key)) {
            return false;
        }
        issuedBooks.put(key, issueDate);
        return true;
    }

    /**
     * Returns true if the book is not currently issued.
     */
    public boolean isAvailable(String title) {
        return !issuedBooks.containsKey(normalize(title));
    }

    /**
     * Returns a book and calculates the fine (Rs) for late return.
     */
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

    /**
     * Checks whether a book exists in the library.
     */
    public boolean hasBook(String title) {
        return books.contains(normalize(title));
    }
}