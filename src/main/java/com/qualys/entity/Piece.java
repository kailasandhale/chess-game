package com.qualys.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public boolean isValidTarget(List<Square> square) {
        return square.stream().allMatch(currentPosition -> isValidMove(this.getPosition(),currentPosition));
    }

    protected  Player getOpponentPlayer() {
        return new Player(!this.isWhite());
    }

    protected abstract List<Square> getSquaresTillLocation(Square position);
}
