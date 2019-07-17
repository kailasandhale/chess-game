package com.qualys.entity;

import java.util.ArrayList;
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
    protected List<Square> getSquaresTillLocation(Square target) {
        Square currentPosition = this.getPosition();
        if(currentPosition.getX() == target.getX() || currentPosition.getY() == target.getY()){
            return getSquaresTillLocationForRook(currentPosition,target);
        } else {
            return getSquaresTillLocationForBishop(currentPosition,target);
        }
    }

    protected List<Square> getSquaresTillLocationForBishop(Square currentPosition, Square target) {
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

    protected List<Square> getSquaresTillLocationForRook(Square currentPosition, Square target) {
        int horizontalDiff = this.getPosition().getX() - target.getX();
        int verticalDiff = this.getPosition().getY() - target.getY();
        List<Square> squaresTillPosition = new ArrayList<>();
        if(0 == horizontalDiff){
            return getVerticalSquares(this.getPosition(), verticalDiff);
        } else if (0 == verticalDiff){
            return getHorizontalSquares(this.getPosition(), horizontalDiff);
        }
        return squaresTillPosition;
    }

    private List<Square> getHorizontalSquares(Square source, int offset) {
        List<Square> squares = new ArrayList<>();
        for(int location = 0; location< offset; location++){
            squares.add(new Square(source.getX(),source.getY() + location));
        }
        return squares;
    }

    private List<Square> getVerticalSquares(Square source, int offset) {
        List<Square> squares = new ArrayList<>();
        for(int location = 0; location< offset; location++){
            squares.add(new Square(source.getX() + location, source.getY()));
        }
        return squares;
    }

    private int getFactor(boolean condition) {
        int horizontalFactor = 1;
        if (condition) {
            horizontalFactor = -1;
        }
        return horizontalFactor;
    }


}
