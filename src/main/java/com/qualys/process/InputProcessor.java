package com.qualys.process;

import com.qualys.entity.Piece;
import com.qualys.entity.Player;
import com.qualys.util.CacheUtil;

import java.util.List;

public class InputProcessor {

    public boolean isCheckMate(List<Piece> pieces, Player player)  {
        initialize(pieces);
        return player.isCheckMate();
    }


    private void initialize(List<Piece> pieces) {
        pieces.forEach(piece -> CacheUtil.addPieceToSquare(piece.getPosition(),piece));
        pieces.forEach(piece -> CacheUtil.getPlayer(piece.isWhite()).addPiece(piece));
    }

}
