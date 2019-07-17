package com.qualys.entity;

import java.util.List;

public class Queen extends Piece {

    @Override
    protected boolean isValidMove(Square source, Square dest) {
        if(super.isValidMove(source, dest)){
            return false;
        }

        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return horizontalDiff == verticalDiff || source.getX() == dest.getX() || source.getY() == dest.getY();
    }

    @Override
    public boolean isValidTarget(Square square) {
        return false;
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return null;
    }
}
