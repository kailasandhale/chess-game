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
    protected boolean isValidMove(Board board, Square source, Square dest){
        if(source.equals(dest)){
            return false;
        }
        return source.isValid() && dest.isValid();
    }

    public abstract List<Square> getPossibleMoves(Board board, Player player);

    public abstract boolean isValidTarget(Square square);
}
