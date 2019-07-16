package com.qualys.entity;

import com.qualys.exception.IllegalStatesException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = "pieces")
public class Player {
    private boolean white;
    private List<Piece> pieces;

    public Player(boolean white) {
        this.white = white;
    }

    public boolean isOpponentPiece(Piece piece) {
        return pieces.stream().noneMatch(piece::equals);
    }

    public boolean addPiece(Piece piece){
        return pieces.add(piece);
    }

    public boolean removePiece(Piece piece){
        return pieces.remove(piece);
    }

    public boolean isCheckMate() throws IllegalStatesException {
        King king = this.getKing();
        return king.isCheckMate();
    }

    private King getKing() throws IllegalStatesException {
        return (King) this.getPieces().stream()
                .filter(piece -> piece instanceof King).findFirst()
                .orElseThrow(() -> new IllegalStatesException(IllegalStatesException.KING_NOT_PRESENT_EXCEPTION));
    }

}
