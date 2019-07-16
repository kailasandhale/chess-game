package com.qualys.process;

import com.qualys.exception.IllegalStatesException;
import com.qualys.entity.Board;
import com.qualys.entity.King;
import com.qualys.entity.Player;

public class ResultProcessor {

    public boolean isCheckMate(Board board, Player player) throws IllegalStatesException {
        King king = (King) player.getPieces().stream()
                .filter(piece -> piece instanceof King)
                .findFirst()
                .orElseThrow(() -> new IllegalStatesException(IllegalStatesException.KING_NOT_PRESENT_EXCEPTION));

        return true;
    }
}
