package com.qualys.entity;

import java.util.List;

public class Knight extends Piece {

    public Knight(boolean alive, Square position) {
        super(alive, position);
    }

    @Override
    protected boolean isValidMove(Board board, Square source, Square dest) {
        if(!super.isValidMove(board, source, dest)){
            return false;
        }
        int x = Math.abs(source.getX() - dest.getX());
        int y = Math.abs(source.getY() - dest.getY());
        return x * y == 2;
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
