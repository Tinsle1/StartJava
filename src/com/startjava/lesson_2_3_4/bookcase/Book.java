package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;
import java.util.Objects;

public class Book {
    public static final Year MIN_PUBLISHED_YEAR = Year.of(1800);
    public static Year maxPublishedYear = Year.now();

    private final String author;
    private final String title;
    private final Year publishedYear;

    public Book(String title, String author, Year publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Year getYear() {
        return publishedYear;
    }

    public int getDisplayLength() {
        return toString().length();
    }

    @Override
    public String toString() {
        return "%s, «%s», %d".formatted(author, title, publishedYear.getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book book = (Book) obj;

        return author.equalsIgnoreCase(book.author) &&
                title.equalsIgnoreCase(book.title) &&
                publishedYear.equals(book.publishedYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, publishedYear);
    }
}
