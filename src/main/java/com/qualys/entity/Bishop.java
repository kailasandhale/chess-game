package com.qualys.entity;

import java.util.List;

public class Bishop extends Piece {

    @Override
    protected boolean isValidMove( Square source, Square dest) {
        if(!super.isValidMove( source, dest)){
            return false;
        }
        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return  horizontalDiff == verticalDiff;
    }

    @Override
    public boolean isValidTarget(Square square) {
        return false;
    }

    @Override
    public boolean isValidTarget(List<Square> square) {
        return false;
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return null;
    }
}
