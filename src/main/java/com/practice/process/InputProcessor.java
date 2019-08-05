package com.practice.process;

import com.practice.entity.Piece;
import com.practice.entity.Player;
import com.practice.util.CacheUtil;

import java.util.List;

class InputProcessor {

    public boolean isCheckMate(List<Piece> pieces, Player player)  {
        initialize(pieces);
        return player.isCheckMate();
    }


    private void initialize(List<Piece> pieces) {
        pieces.forEach(piece -> CacheUtil.addPieceToSquare(piece.getPosition(),piece));
        pieces.forEach(piece -> CacheUtil.getPlayer(piece.isWhite()).addPiece(piece));
    }

}
