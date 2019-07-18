package com.qualys.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Piece {
    private boolean alive;
    private Square position;
    private boolean white;
    protected boolean isValidMove( Square source, Square dest){
        if(source.equals(dest)){
            return false;
        }
        return source.isValid() && dest.isValid();
    }

    public boolean isValidTarget(Square square) {
        return isValidMove(this.getPosition(),square);
    }

    public boolean isAnyValidTarget(List<Square> squares) {
        return squares.stream().anyMatch(currentPosition -> isValidMove(this.getPosition(),currentPosition));
    }

    protected abstract List<Square> getSquaresTillLocation(Square position);
}
