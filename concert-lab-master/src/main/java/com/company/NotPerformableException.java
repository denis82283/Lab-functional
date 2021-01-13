package com.company;

public class NotPerformableException extends UnsupportedOperationException {
    public NotPerformableException() {
        super("Cannot perform with this instrument");
    }
}
