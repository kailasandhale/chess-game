package com.qualys.entity;

import java.util.List;

public class Rook extends Piece {

    @Override
    protected boolean isValidMove(Square source, Square dest) {
        if(!super.isValidMove(source, dest)){
            return false;
        }
        return source.getX() == dest.getX() || source.getY() == dest.getY();
    }

    @Override
    public List<Square> getPossibleMoves( Player player) {
        return null;
    }

    @Override
    public boolean isValidTarget(Square square) {
        return false;
    }
}
