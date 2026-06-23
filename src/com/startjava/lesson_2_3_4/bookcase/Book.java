package com.startjava.lesson_2_3_4.bookcase;

public class Book {
    public static final int MIN_YEAR = 1800;
    public static final int MAX_YEAR = 2026;

    private final String author;
    private final String title;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "%s, «%s», %d".formatted(author, title, year);
    }
}
