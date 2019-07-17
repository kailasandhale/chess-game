package com.qualys.behaviour;

import com.qualys.entity.Square;

import java.util.ArrayList;
import java.util.List;

public interface MovementBehaviour {
     default List<Square> rookMovement(Square source, Square target) {
        int horizontalDiff = source.getX() - target.getX();
        int verticalDiff = source.getY() - target.getY();
        List<Square> squaresTillPosition = new ArrayList<>();
        if(0 == horizontalDiff){
            return getVerticalSquares(source, verticalDiff);
        } else if (0 == verticalDiff){
            return getHorizontalSquares(source, horizontalDiff);
        }
        return squaresTillPosition;
    }

    default List<Square> bishopMovement(Square source, Square target) {
        int horizontalDiff = target.getX() - source.getX();
        int verticalDiff = target.getY() - source.getY();

        int horizontalFactor = getFactor(horizontalDiff < 0);
        int verticalFactor = getFactor(verticalDiff < 0);

        List<Square> squares = new ArrayList<>();
        while (!source.equals(target)) {
            squares.add(source);
            source.setX(source.getX() + horizontalFactor);
            source.setY(source.getY() + verticalFactor);
        }
        return squares;
    }

    default int getFactor(boolean condition) {
        int horizontalFactor = 1;
        if (condition) {
            horizontalFactor = -1;
        }
        return horizontalFactor;
    }

    default List<Square> getHorizontalSquares(Square source, int offset) {
        List<Square> squares = new ArrayList<>();
        for(int location = 0; location< offset; location++){
            squares.add(new Square(source.getX(),source.getY() + location));
        }
        return squares;
    }

    default List<Square> getVerticalSquares(Square source, int offset) {
        List<Square> squares = new ArrayList<>();
        for(int location = 0; location< offset; location++){
            squares.add(new Square(source.getX() + location, source.getY()));
        }
        return squares;
    }
}
