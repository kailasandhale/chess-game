package com.qualys.entity;

import com.qualys.util.CacheUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class King extends Piece {

    public King(Square position, boolean isWhite){
        super(true,position,isWhite);
    }

    @Override
    public boolean isValidMove(Square source, Square dest){
       if(!super.isValidMove(source,dest)){
           return false;
       }
        int horizontalDiff = Math.abs(source.getX() - dest.getX());
        int verticalDiff = Math.abs(source.getY() - dest.getY());
        return horizontalDiff <= 1 && verticalDiff <= 1 && horizontalDiff + verticalDiff >= 1;
    }

    private List<Square> getPossibleMoves(Player player) {
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
            Piece pieceAtSquare = CacheUtil.getPiece(square);
            if (square.isValid() && (CacheUtil.getPiece(square) == null || player.isOpponentPiece(pieceAtSquare) )) {
                possibleMoves.add(square);
            }
        }

        return possibleMoves;
    }

    @Override
    protected List<Square> getSquaresTillLocation(Square position) {
        return Collections.emptyList();
    }

    public boolean isCheckMate() {
        Player player = CacheUtil.getPlayer(this.isWhite());
        Player opponent = CacheUtil.getOpponent(player);
        List<Piece> opponentPiecesGivingCheck = getOpponentPiecesGivingCheck(opponent);
        List<Square> possibleMoves = getPossibleMoves(player);
        if(opponentPiecesGivingCheck.isEmpty() || !allPossiblePositionsChecked(opponent, possibleMoves)){
            return false;
        } else if(opponentPiecesGivingCheck.size() > 1){
            return true;
        } else if(opponentPiecesGivingCheck.size() == 1){
            Piece pieceGivingCheck = opponentPiecesGivingCheck.get(0);
            return !canBeKilledOrBlocked(pieceGivingCheck);
        }
        return false;
    }

    private boolean canBeKilledOrBlocked(Piece opponentPiece) {
        List<Square> squaresFromPieceToKing = getSquaresBetweenPieceAndKing(opponentPiece);
        Player player = CacheUtil.getPlayer(this.isWhite());
        return player.getPieces().stream().filter(piece -> !(piece instanceof King)).anyMatch(piece ->  piece.isAnyValidTarget(squaresFromPieceToKing));
    }

    private List<Square> getSquaresBetweenPieceAndKing(Piece piece) {
        return piece.getSquaresTillLocation(this.getPosition());
    }

    private boolean allPossiblePositionsChecked(Player opponent, List<Square> possibleMoves) {
        List<Piece> opponentPieces = opponent.getPieces();
        for(Piece opponentPiece: opponentPieces){
            updatePossibleMoves(opponentPiece,possibleMoves);
        }
        return possibleMoves.isEmpty();
    }

    private void updatePossibleMoves(Piece piece, List<Square> possibleMoves) {
        List<Square> unavailableSquares = new ArrayList<>();
        for(Square square:possibleMoves){
            if(piece.isValidTarget(square)){
                unavailableSquares.add(square);
            }
        }
        possibleMoves.removeAll(unavailableSquares);
    }

    private List<Piece> getOpponentPiecesGivingCheck(Player opponent) {

        return opponent.getPieces().stream()
                .filter(piece -> piece.isValidTarget(this.getPosition()))
                .collect(Collectors.toList());
    }

}
