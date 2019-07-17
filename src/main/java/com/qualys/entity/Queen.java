package com.qualys.entity;

import com.qualys.behaviour.MovementBehaviour;

import java.util.List;

public class Queen extends Piece implements MovementBehaviour {

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
            return rookMovement(currentPosition,target);
        } else {
            return bishopMovement(currentPosition,target);
        }
    }

}
