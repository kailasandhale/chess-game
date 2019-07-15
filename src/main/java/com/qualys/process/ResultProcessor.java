package com.qualys.process;

import com.qualys.exception.IllegalStateException;
import com.qualys.entity.Board;
import com.qualys.entity.King;
import com.qualys.entity.Piece;
import com.qualys.entity.Player;

public class ResultProcessor {

    public boolean isCheckMate(Board board, Player player) throws IllegalStateException {
        Piece king = player.getPieces().stream()
                .filter(piece -> piece instanceof King)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(IllegalStateException.KING_NOT_PRESENT_EXCEPTION));

        return true;
    }
}
