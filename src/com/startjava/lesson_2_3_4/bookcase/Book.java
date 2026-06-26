package com.startjava.lesson_2_3_4.bookcase;

import java.time.Year;

public class Book {
    public static final Year MIN_PUBLICATION_YEAR = Year.of(1800);
    public static final Year MAX_PUBLICATION_YEAR = Year.now();

    private final String author;
    private final String title;
    private final Year publicationYear;

    public Book(String title, String author, Year year) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "%s, «%s», %d".formatted(author, title, publicationYear.getValue());
    }
}
