package com.qualys.exception;

public class IllegalStateException extends Exception {

    public static final String KING_NOT_PRESENT_EXCEPTION = "King Not present.";
    private String message;

    public IllegalStateException(String message){
        super(message);
    }
}
