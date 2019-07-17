package com.qualys.util;

import com.qualys.entity.Piece;
import com.qualys.entity.Player;
import com.qualys.entity.Square;
import com.qualys.exception.IllegalStatesException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.qualys.exception.IllegalStatesException.OPPONENT_NOT_PRESENT_EXCEPTION;
import static com.qualys.util.Constants.BLACK;
import static com.qualys.util.Constants.WHITE;

public class CacheUtil {

    private CacheUtil(){
        /* Added a private constructor to hide implicit public one */
    }
    private static final List<Player> players = Arrays.asList(new Player(WHITE), new Player(BLACK));

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
