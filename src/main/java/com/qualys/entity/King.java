package com.qualys.entity;

import com.qualys.exception.IllegalStatesException;
import com.qualys.util.CacheUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class King extends Piece {

    @Override
    public boolean isValidMove(Square source, Square dest){
       if(!super.isValidMove(source,dest)){
           return false;
       }
        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return horizontalDiff <= 1 && verticalDiff <= 1 && horizontalDiff + verticalDiff >= 1;
    }

    @Override
    public List<Square> getPossibleMoves(Player player) {
        List<Square> possibleMoves = new ArrayList<>();
        Square currentPosition = this.getPosition();
        int[][] offsets = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1},
                {1, 1},
                {-1, 1},
                {-1, -1},
                {1, -1}
        };

        for (int[] offset : offsets) {
            Square square = currentPosition.getNeighbour(offset[0], offset[1]);
            if (square.isValid() && (CacheUtil.getPiece(square) == null || player.isOpponentPiece(CacheUtil.getPiece(square)))) {
                possibleMoves.add(square);
            }
        }

        return possibleMoves;
    }

    public boolean isCheckMate() throws IllegalStatesException {
        Player opponent = getOpponentPlayer();
        List<Piece> opponentPiecesGivingCheck = getOpponentPiecesGivingCheck(opponent);
        List<Square> possibleMoves = getPossibleMoves(CacheUtil.getPlayer(this.isWhite()));
        if(opponentPiecesGivingCheck.isEmpty() || !allPossiblePositionsChecked(opponent, possibleMoves)){
            return false;
        } else if(opponentPiecesGivingCheck.size() > 1){
            return true;
        }

        return true;
    }

    @Override
    public boolean isValidTarget(List<Square> square) {
        return false;
    }

    private boolean allPossiblePositionsChecked(Player opponent, List<Square> possibleMoves) {
        return opponent.getPieces().stream()
                .allMatch(piece -> piece.isValidTarget(possibleMoves));
    }


    private List<Piece> getOpponentPiecesGivingCheck(Player opponent) {

        return opponent.getPieces().stream()
                .filter(piece -> piece.isValidTarget(this.getPosition()))
                .collect(Collectors.toList());
    }

}
