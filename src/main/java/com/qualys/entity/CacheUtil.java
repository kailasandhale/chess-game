package com.qualys.entity;

import java.util.HashMap;
import java.util.Map;

public class CacheUtil {
    private static final Map<Square, Piece> squarePieceMap = new HashMap<>();

    public static Piece getPiece(Square square){
        return squarePieceMap.get(square);
    }
}
