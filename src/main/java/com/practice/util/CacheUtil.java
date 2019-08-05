package com.practice.util;

import com.practice.entity.Piece;
import com.practice.entity.Player;
import com.practice.entity.Square;
import com.practice.exception.IllegalStatesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.practice.exception.IllegalStatesException.OPPONENT_NOT_PRESENT_EXCEPTION;
import static com.practice.exception.IllegalStatesException.PLAYER_NOT_PRESENT_EXCEPTION;

public class CacheUtil {

    private CacheUtil(){
        /* Added a private constructor to hide implicit public one */
    }
    private static final List<Player> players = new ArrayList<>();

    private static final Map<Square, Piece> squarePieceMap = new HashMap<>();

    public static Piece getPiece(Square square){
        return squarePieceMap.get(square);
    }

    public static boolean addPieceToSquare(Square square, Piece piece){
        if(Objects.nonNull(squarePieceMap.get(square))){
            return false;
        }
        squarePieceMap.put(square,piece);
        return true;
    }

    public static void clear(){
        squarePieceMap.clear();
        players.remove(1);
        players.remove(0);
    }

    public static Player getPlayer(boolean isWhite) {
        Player player = new Player(isWhite);
        Optional<Player> optionalPlayer = players.stream().filter(player::equals).findFirst();
        return optionalPlayer.orElseThrow(() -> new IllegalStatesException(PLAYER_NOT_PRESENT_EXCEPTION));
    }

    public static Player getOpponent(Player player) {
        Player opponent = new Player(!player.isWhite());
        Optional<Player> optionalPlayer = players.stream().filter(opponent::equals).findFirst();
        return optionalPlayer.orElseThrow(() -> new IllegalStatesException(OPPONENT_NOT_PRESENT_EXCEPTION));
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }
}
