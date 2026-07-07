package com.startjava.lesson_2_3_4.bookcase.exception;

public class InvalidMenuNumberException extends RuntimeException {
    public InvalidMenuNumberException(String message) {
        super(message);
    }
}
