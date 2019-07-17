package com.qualys.entity;

import java.util.Collections;
import java.util.List;

public class Pawn extends Piece {

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return Collections.singletonList(this.getPosition());
    }
}
