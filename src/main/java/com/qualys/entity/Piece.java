package com.qualys.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Piece {
    private boolean alive;
    private Square position;
    protected boolean isValidMove(Board board, Square source, Square dest){
        if(source.equals(dest)){
            return false;
        }
        return source.isValid() && dest.isValid();
    }

    public abstract List<Square> getPossibleMoves(Board board, Player player);

    public abstract boolean isValidTarget(Square square);
}
