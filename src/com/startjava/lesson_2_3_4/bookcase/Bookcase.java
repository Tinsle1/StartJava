package com.startjava.lesson_2_3_4.bookcase;

import com.startjava.lesson_2_3_4.bookcase.exception.AlreadyExistException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookNotFoundException;
import com.startjava.lesson_2_3_4.bookcase.exception.BookcaseFullException;
import java.util.Arrays;

public class Bookcase {
    public static final int CAPACITY = 10;

    private Book[] books = new Book[CAPACITY];
    private int booksCount = 0;
    private int bookcaseLength;

    public Book[] getBooks() {
        return Arrays.copyOf(books, booksCount);
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getBookcaseLength() {
        return bookcaseLength;
    }

    public void addBook(Book bookToAdd) {
        if (isFull()) {
            throw new BookcaseFullException("""
                    Книжный шкаф переполнен.
                    Освободите полку, чтобы добавить книгу
                    """);
        }

        for (int i = 0; i < booksCount; i++) {
            if (bookToAdd.equals(books[i])) {
                throw new AlreadyExistException(
                        "Книга уже добавлена в шкаф: %s".formatted(books[i]));
            }
        }

        books[booksCount] = bookToAdd;
        booksCount++;

        int bookLength = bookToAdd.toString().length();
        if (bookLength > bookcaseLength) {
            bookcaseLength = bookLength;
        }
    }

    public boolean isFull() {
        return booksCount >= CAPACITY;
    }

    public Book[] findBooks(String title) {
        Book[] foundBooks = new Book[booksCount];
        int index = 0;
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                foundBooks[index] = book;
                index++;
            }
        }
        if (index > 0) {
            return Arrays.copyOf(foundBooks, index);
        }
        throw new BookNotFoundException("Книга не найдена");
    }

    public void removeBook(String title) {
        for (int i = 0; i < booksCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                int length = books[i].getDisplayLength();

                System.arraycopy(books, i + 1, books, i, booksCount - i - 1);
                booksCount--;
                i--;

                if (length == bookcaseLength) {
                    bookcaseLength = calculateBookcaseLength();
                }
            }
        }
    }

    public void clear() {
        Arrays.fill(books, 0, booksCount, null);
        booksCount = 0;
    }

    public int countEmptyShelves() {
        return CAPACITY - booksCount;
    }

    public boolean isEmpty() {
        return booksCount == 0;
    }

    public int calculateBookcaseLength() {
        int maxLength = books[0].toString().length();
        for (int i = 1; i < booksCount; i++) {
            if (books[i].toString().length() > maxLength) {
                maxLength = books[i].toString().length();
            }
        }
        return maxLength;
    }
}
