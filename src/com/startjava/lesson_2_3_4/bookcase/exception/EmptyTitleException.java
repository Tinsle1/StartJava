package com.startjava.lesson_2_3_4.bookcase.exception;

public class EmptyTitleException extends RuntimeException {
    public EmptyTitleException(String message) {
        super(message);
    }
}
