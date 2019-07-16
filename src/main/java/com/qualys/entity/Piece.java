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

    public abstract List<Square> getPossibleMoves(Player player);

    public boolean isValidTarget(Square square) {
        return getPossibleMoves(this.getPlayer()).contains(square);
    }

    public boolean isValidTarget(List<Square> square) {
        List<Square> possibleMoves = getPossibleMoves(this.getPlayer());
        return possibleMoves.containsAll(square);
    }

    protected  Player getOpponentPlayer() {
        return new Player(!this.isWhite());
    }

    protected Player getPlayer() {
        return new Player(this.isWhite());
    }

    protected abstract List<Square> getSquaresTillLocation(Square position);
}
