package com.qualys.entity;

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
}
