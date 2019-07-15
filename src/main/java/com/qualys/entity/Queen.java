package com.qualys.entity;

import java.util.List;

public class Queen extends Piece {
    public Queen(boolean alive, Square position) {
        super(alive, position);
    }

    @Override
    protected boolean isValidMove(Board board, Square source, Square dest) {
        if(super.isValidMove(board, source, dest)){
            return false;
        }

        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return horizontalDiff == verticalDiff || source.getX() == dest.getX() || source.getY() == dest.getY();
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
