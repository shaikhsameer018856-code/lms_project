package com.hitms.lms;

import java.time.LocalDate;
import com.hitms.lms.util.LibraryUtils;

public class Main {

    public static void main(String[] args) {

        System.out.println(
            LibraryUtils.formatTitle(" Hy Sameer ")
        );

        System.out.println(
            LibraryUtils.daysBetween(
                LocalDate.of(2026, 2, 10),
                LocalDate.of(2026, 2, 20)
            )
        );
         LibraryService service = new LibraryService();
        System.out.println("Add book: " + service.addBook("  DSA "));
        System.out.println("Add duplicate: " + service.addBook("DBMS"));
        System.out.println("Total books: " + service.bookCount());

        LocalDate issueDate = LocalDate.of(2026, 1, 1);
        System.out.println("Issue book: " + service.issueBook("the great gatsby", issueDate));
        System.out.println("Issue again: " + service.issueBook("the great gatsby", issueDate));
        System.out.println("Available: " + service.isAvailable("the great gatsby"));

        long fine = service.returnBook("the great gatsby", LocalDate.of(2026, 1, 20));
        System.out.println("Fine (Rs): " + fine);
        System.out.println("Available: " + service.isAvailable("the great gatsby"));
    } 

}
