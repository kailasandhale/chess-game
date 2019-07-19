package com.qualys.entity;

import com.qualys.util.CacheUtil;

import java.util.Collections;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Square position, boolean white) {
        super(true, position, white);
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return Collections.singletonList(this.getPosition());
    }

    @Override
    protected boolean isValidMove(Square source, Square dest) {
        if(!super.isValidMove(source, dest)){
            return false;
        }
        int horizontalDiff = Math.abs(source.getX()  - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        Piece destinationPiece = CacheUtil.getPiece(dest);
        if(horizontalDiff == 0 && verticalDiff == 1 && destinationPiece == null ){
            return true;
        }

        Player player = CacheUtil.getPlayer(this.isWhite());

        return horizontalDiff == 1 && verticalDiff == 1 && player.isOpponentPiece(destinationPiece);
    }
}
