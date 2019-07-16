package com.qualys.process;

import com.qualys.entity.Board;
import com.qualys.entity.King;
import com.qualys.entity.Piece;
import com.qualys.entity.Square;
import com.qualys.util.CacheUtil;
import org.junit.Before;
import org.junit.Test;

import static com.qualys.util.Constants.BLACK;
import static com.qualys.util.Constants.WHITE;

public class InputProcessorTest {

    private Board board;
    private InputProcessor inputProcessor;

    @Before
    public void setup(){
        board = new Board();
        inputProcessor = new InputProcessor();
    }

    @Test
    public void testCheck() {
        Square[][] squares = board.getSquares();
        CacheUtil.addPieceToSquare(squares[0][0], getKing(WHITE));
        CacheUtil.addPieceToSquare(squares[7][7], getKing(BLACK));
        inputProcessor.isCheckMate(CacheUtil.getSquarePieceMap(),WHITE);
    }

    private Piece getKing(boolean isWhite) {
        return King.builder().alive(true).white(isWhite).build();
    }
}