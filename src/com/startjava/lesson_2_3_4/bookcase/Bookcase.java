package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.BookIsAddedException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookNotFoundException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseIsFullException;
import java.util.Arrays;

public class Bookcase {
    public static final int MAX_BOOKS_COUNT = 10;
    private static final Book[] BOOKS = new Book[MAX_BOOKS_COUNT];

    private static int booksCount = 0;

    public static void addBook(Book book) {
        if (booksCount > MAX_BOOKS_COUNT - 1) {
            throw new BookcaseIsFullException(
                    "Книжный шкаф переполнен.\n" +
                    "Освободите полку, чтобы добавить книгу");
        }

        if (isBookAdded(book)) {
            throw new BookIsAddedException("Книга уже добавлена в шкаф");
        }

        BOOKS[booksCount] = book;
        booksCount++;

        System.out.printf("%nКнига «%s» добавлена в шкаф%n", book.getTitle());
    }

    private static boolean isBookAdded(Book book) {
        if (booksCount > 0) {
            for (Book bookInShelf : BOOKS) {
                if (book.equals(bookInShelf)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Book findBook(String title) {
        for (Book book : BOOKS) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("Книга не найдена");
    }

    public static void clear() {
        Arrays.fill(BOOKS, null);
        booksCount = 0;
    }

    public static Book[] getBooks() {
        return Arrays.copyOf(BOOKS, booksCount);
    }

    public static int getBooksCount() {
        return booksCount;
    }

    public static int emptyShelvesCount() {
        return MAX_BOOKS_COUNT - booksCount;
    }
}
