package com.qualys.entity;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    @Override
    protected boolean isValidMove(Square source, Square dest) {
        if(!super.isValidMove(source, dest)){
            return false;
        }
        return source.getX() == dest.getX() || source.getY() == dest.getY();
    }

    @Override
    public boolean isValidTarget(Square square) {
        return false;
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        int horizontalDiff = this.getPosition().getX() - position.getX();
        int verticalDiff = this.getPosition().getY() - position.getY();
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
}
