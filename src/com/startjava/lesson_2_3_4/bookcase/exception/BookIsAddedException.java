package com.startjava.lesson_2_3_4.bookcase.exception;

public class BookIsAddedException extends RuntimeException {
    public BookIsAddedException(String message) {
        super(message);
    }
}
