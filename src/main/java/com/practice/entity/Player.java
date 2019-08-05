package com.practice.entity;

import com.practice.exception.IllegalStatesException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = "pieces")
public class Player {
    private boolean white;
    private List<Piece> pieces;

    public Player(boolean white) {
        this.white = white;
        pieces = new ArrayList<>();
    }

    public boolean isOpponentPiece(Piece piece) {
        return piece.isWhite() != this.isWhite();
    }

    public boolean addPiece(Piece piece){
        return pieces.add(piece);
    }

    public boolean removePiece(Piece piece){
        return pieces.remove(piece);
    }

    public boolean isCheckMate(){
        King king = this.getKing();
        return king.isCheckMate();
    }

    private King getKing(){
        return (King) this.getPieces().stream()
                .filter(piece -> piece instanceof King).findFirst()
                .orElseThrow(() -> new IllegalStatesException(IllegalStatesException.KING_NOT_PRESENT_EXCEPTION));
    }

}
