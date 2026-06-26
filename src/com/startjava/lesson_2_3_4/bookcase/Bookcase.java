package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.AlreadyExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookNotFoundException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseFullException;
import java.util.Arrays;

public class Bookcase {
    public static final int CAPACITY = 10;
    private static final Book[] BOOKS = new Book[CAPACITY];

    private static int booksCount = 0;

    public static void addBook(Book book) {
        if (booksCount >= CAPACITY) {
            throw new BookcaseFullException("""
                    Книжный шкаф переполнен.
                    "Освободите полку, чтобы добавить книгу
                    """);
        }

        if (hasBook(book)) {
            throw new AlreadyExistException("Книга уже добавлена в шкаф");
        }

        BOOKS[booksCount] = book;
        booksCount++;
    }

    private static boolean hasBook(Book bookToAdd) {
        if (booksCount > 0) {
            for (Book bookInShelf : BOOKS) {
                if (bookToAdd.equals(bookInShelf)) {
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
        Arrays.fill(BOOKS, 0, booksCount + 1, null);
        booksCount = 0;
    }

    public static Book[] getBooks() {
        return Arrays.copyOf(BOOKS, booksCount);
    }

    public static int getBooksCount() {
        return booksCount;
    }

    public static int countEmptyShelves() {
        return CAPACITY - booksCount;
    }
}
