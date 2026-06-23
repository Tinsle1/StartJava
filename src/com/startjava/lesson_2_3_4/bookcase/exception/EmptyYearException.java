package com.startjava.lesson_2_3_4.bookcase.exception;

public class EmptyYearException extends RuntimeException {
    public EmptyYearException(String message) {
        super(message);
    }
}
