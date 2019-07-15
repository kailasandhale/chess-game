package com.qualys.entity;

import lombok.Data;

import java.util.List;

@Data
public class Player {
    private boolean white;
    private List<Piece> pieces;

    public boolean isOpponentPiece(Piece piece) {
        return pieces.stream().noneMatch(piece::equals);
    }
}
