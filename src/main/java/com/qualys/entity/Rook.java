package com.qualys.entity;

import com.qualys.behaviour.MovementBehaviour;

import java.util.List;

public class Rook extends Piece implements MovementBehaviour {

    public Rook(Square position, boolean white) {
        super(true, position, white);
    }

    @Override
    protected boolean isValidMove(Square source, Square dest) {
        if(!super.isValidMove(source, dest)){
            return false;
        }
        return source.getX() == dest.getX() || source.getY() == dest.getY();
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square target) {
        return rookMovement(this.getPosition(), target);
    }
}
