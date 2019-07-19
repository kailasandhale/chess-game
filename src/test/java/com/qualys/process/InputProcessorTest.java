package com.qualys.process;

import com.qualys.entity.Bishop;
import com.qualys.entity.King;
import com.qualys.entity.Knight;
import com.qualys.entity.Piece;
import com.qualys.entity.Player;
import com.qualys.entity.Queen;
import com.qualys.entity.Rook;
import com.qualys.entity.Square;
import com.qualys.util.CacheUtil;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.qualys.util.Constants.BLACK;
import static com.qualys.util.Constants.WHITE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputProcessorTest {

    @After
    public void tearDown(){
        CacheUtil.clear();
    }

    @Test
    public void isCheckMate_OnlyKingsPresent_No_Checkmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new King(new Square(0,0), WHITE));
        pieces.add(new King(new Square(3,3), BLACK));
        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, white);
        assertFalse(checkmate);
    }

    @Test
    public void isCheckMate_QueenGivingCheck_No_Checkmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(new Square(7,7), WHITE));
        pieces.add(new King(new Square(3,3), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertFalse(checkmate);

    }

    @Test
    public void isCheckMate_QueenAndKnightGivingCheck_NoCheckmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(new Square(7,7), WHITE));
        pieces.add(new Knight(new Square(2,1), WHITE));
        pieces.add(new King(new Square(3,3), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertFalse(checkmate);

    }

    @Test
    public void isCheckMate_RookGivingCheck_Checkmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(new Square(1,7), WHITE));
        pieces.add(new Rook(new Square(0,5), WHITE));
        pieces.add(new King(new Square(0,0), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertTrue(checkmate);
    }


    @Test
    public void isCheckMate_QueenGivingCheckVertically_Checkmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(new Square(7,0), WHITE));
        pieces.add(new Rook(new Square(7,1), WHITE));
        pieces.add(new King(new Square(0,0), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertTrue(checkmate);

    }

    @Test
    public void isCheckMate_MultiplePiecesGivingCheck_Checkmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Bishop(new Square(7,7), WHITE));
        pieces.add(new Queen(new Square(1,7), WHITE));
        pieces.add(new Rook(new Square(0,5), WHITE));
        pieces.add(new Rook(new Square(7,0), WHITE));
        pieces.add(new Knight(new Square(1,2), WHITE));
        pieces.add(new King(new Square(0,0), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertTrue(checkmate);

    }

    @Test
    public void isCheckMate_QueenPiecesGivingCheck_Checkmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(new Square(1,1), WHITE));
        pieces.add(new Knight(new Square(2,3), WHITE));
        pieces.add(new King(new Square(0,0), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertTrue(checkmate);

    }

    @Test
    public void isCheckMate_RookGivingCheck_SavedByKnightNoCheckmate() {
        InputProcessor inputProcessor = new InputProcessor();
        List<Piece> pieces = new ArrayList<>();
        pieces.add(new Queen(new Square(1,7), WHITE));
        pieces.add(new Rook(new Square(0,5), WHITE));
        pieces.add(new King(new Square(0,0), BLACK));
        pieces.add(new Knight(new Square(2,2), BLACK));

        Player white = new Player(WHITE);
        Player black = new Player(BLACK);
        CacheUtil.addPlayer(white);
        CacheUtil.addPlayer(black);
        boolean checkmate = inputProcessor.isCheckMate(pieces, black);
        assertFalse(checkmate);

    }

}