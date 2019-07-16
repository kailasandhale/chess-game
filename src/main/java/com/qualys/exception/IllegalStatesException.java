package com.qualys.exception;

public class IllegalStatesException extends Exception {

    public static final String KING_NOT_PRESENT_EXCEPTION = "King Not present.";
    private String message;

    public IllegalStatesException(String message){
        super(message);
    }
}
