package com.qualys.entity;

import java.util.List;

public class Rook extends Piece {

    public Rook(boolean alive, Square position) {
        super(alive, position);
    }

    @Override
    protected boolean isValidMove(Board board, Square source, Square dest) {
        if(!super.isValidMove(board, source, dest)){
            return false;
        }
        return source.getX() == dest.getX() || source.getY() == dest.getY();
    }

    @Override
    public List<Square> getPossibleMoves(Board board, Player player) {
        return null;
    }

    @Override
    public boolean isValidTarget(Square square) {
        return false;
    }
}
