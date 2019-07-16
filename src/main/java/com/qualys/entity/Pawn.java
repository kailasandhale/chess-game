package com.qualys.entity;

import java.util.List;

public class Pawn extends Piece {
    @Override
    public List<Square> getPossibleMoves(Player player) {
        return null;
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return null;
    }
}
