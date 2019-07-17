package com.qualys.util;

import com.qualys.entity.Piece;
import com.qualys.entity.Player;
import com.qualys.entity.Square;
import com.qualys.exception.IllegalStatesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.qualys.exception.IllegalStatesException.OPPONENT_NOT_PRESENT_EXCEPTION;

public class CacheUtil {

    private CacheUtil(){
        /* Added a private constructor to hide implicit public one */
    }
    private static List<Player> players = new ArrayList<>(); // This needs to be loaded by the application on startup

    private static final Map<Square, Piece> squarePieceMap = new HashMap<>();

    public static Piece getPiece(Square square){
        return squarePieceMap.get(square);
    }

    public static boolean addPieceToSquare(Square square, Piece piece){
        if(Objects.nonNull(squarePieceMap.get(square))){
            return false;
        }
        squarePieceMap.put(square,piece);
        piece.setPosition(square);
        return true;
    }

    public static Map<Square, Piece> getSquarePieceMap(){
        return squarePieceMap;
    }

    public static Player getPlayer(boolean isWhite) throws IllegalStatesException {
        Player player = new Player(isWhite);
        Optional<Player> optionalPlayer = players.stream().filter(player::equals).findFirst();
        return optionalPlayer.orElseThrow(() -> new IllegalStatesException(OPPONENT_NOT_PRESENT_EXCEPTION));
    }


}
