package com.qualys.entity;

import java.util.Collections;
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
    protected List<Square> getSquaresTillLocation(Square position) {
        return Collections.emptyList(); //TODO this will be implemented in full implementation
    }
}
