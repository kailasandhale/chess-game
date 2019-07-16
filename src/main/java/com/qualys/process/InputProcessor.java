package com.qualys.process;

import com.qualys.entity.Board;
import com.qualys.entity.Piece;
import com.qualys.entity.Player;
import com.qualys.entity.Square;
import com.qualys.util.CacheUtil;

import java.util.Map;

public class InputProcessor {
    Board board = new Board();

    public boolean isCheckMate(Map<Square, Piece> squarePieceMap, boolean isWhite){
        CacheUtil.getSquarePieceMap().clear();
        CacheUtil.getSquarePieceMap().putAll(squarePieceMap);
        Player player = CacheUtil.getPlayer(isWhite);
        return player.isCheckMate();

    }

}
