package com.practice.exception;

public class IllegalStatesException extends RuntimeException {

    public static final String KING_NOT_PRESENT_EXCEPTION = "King Not present.";
    public static final String OPPONENT_NOT_PRESENT_EXCEPTION = "Opponent Not present.";
    public static final String PLAYER_NOT_PRESENT_EXCEPTION = "Opponent Not present.";

    public IllegalStatesException(String message){
        super(message);
    }
}
