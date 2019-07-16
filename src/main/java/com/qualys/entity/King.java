package com.qualys.entity;

import com.qualys.util.CacheUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class King extends Piece {

    @Override
    public boolean isValidMove(Board board, Square source, Square dest){
       if(!super.isValidMove(board,source,dest)){
           return false;
       }
        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return horizontalDiff <= 1 && verticalDiff <= 1 && horizontalDiff + verticalDiff >= 1;
    }

    @Override
    public List<Square> getPossibleMoves(Board board, Player player) {
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

    @Override
    public boolean isValidTarget(Square square) {
        return false;
    }


    public boolean isCheckMate(){
        List<Piece> pieces = getOpponentPiecesGivingCheck();
        if(pieces.isEmpty()){
            return false;
        }
        return true;
    }


    private List<Piece> getOpponentPiecesGivingCheck() {
        Player opponent = new Player(!this.isWhite());
        return opponent.getPieces().stream()
                .filter(piece -> piece.isValidTarget(this.getPosition()))
                .collect(Collectors.toList());
    }
}
