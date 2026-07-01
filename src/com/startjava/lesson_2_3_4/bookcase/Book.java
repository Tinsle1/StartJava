package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;

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

    @Override
    public String toString() {
        return "%s, «%s», %d".formatted(author, title, publishedYear.getValue());
    }
}
