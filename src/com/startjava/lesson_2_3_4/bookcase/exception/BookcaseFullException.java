package com.startjava.lesson_2_3_4.bookcase.exception;

public class BookcaseFullException extends RuntimeException {
    public BookcaseFullException(String message) {
        super(message);
    }
}
