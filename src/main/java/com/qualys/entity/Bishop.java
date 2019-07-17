package com.qualys.entity;

import java.util.ArrayList;
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
    protected List<Square> getSquaresTillLocation(Square target) {
        Square currentPosition = this.getPosition();
        int horizontalDiff = target.getX() - currentPosition.getX();
        int verticalDiff = target.getY() - currentPosition.getY();

        int horizontalFactor = getFactor(horizontalDiff < 0);
        int verticalFactor = getFactor(verticalDiff < 0);

        List<Square> squares = new ArrayList<>();
        while (!currentPosition.equals(target)){
            squares.add(currentPosition);
            currentPosition.setX(currentPosition.getX() + horizontalFactor);
            currentPosition.setY(currentPosition.getY() + verticalFactor);
        }
        return squares;
    }

    int getFactor(boolean condition) {
        int horizontalFactor = 1;
        if (condition) {
            horizontalFactor = -1;
        }
        return horizontalFactor;
    }
}
