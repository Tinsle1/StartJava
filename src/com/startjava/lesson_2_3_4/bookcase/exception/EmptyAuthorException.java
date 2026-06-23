package com.startjava.lesson_2_3_4.bookcase.exception;

public class EmptyAuthorException extends RuntimeException {
    public EmptyAuthorException(String message) {
        super(message);
    }
}
