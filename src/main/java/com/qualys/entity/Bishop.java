package com.qualys.entity;

import com.qualys.behaviour.MovementBehaviour;

import java.util.List;

public class Bishop extends Piece implements MovementBehaviour {

    public Bishop(Square position, boolean white) {
        super(true, position, white);
    }

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
        return bishopMovement(this.getPosition(),target);
    }
}
