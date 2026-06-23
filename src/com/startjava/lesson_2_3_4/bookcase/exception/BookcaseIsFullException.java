package com.startjava.lesson_2_3_4.bookcase.exception;

public class BookcaseIsFullException extends RuntimeException {
    public BookcaseIsFullException(String message) {
        super(message);
    }
}
