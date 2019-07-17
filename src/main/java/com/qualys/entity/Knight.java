package com.qualys.entity;

import java.util.Collections;
import java.util.List;

public class Knight extends Piece {

    @Override
    protected boolean isValidMove(Square source, Square dest) {
        if(!super.isValidMove(source, dest)){
            return false;
        }
        int x = Math.abs(source.getX() - dest.getX());
        int y = Math.abs(source.getY() - dest.getY());
        return x * y == 2;
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return Collections.singletonList(this.getPosition());
    }

}
