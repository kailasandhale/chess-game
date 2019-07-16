package com.qualys.entity;

import com.qualys.util.Constants;

public class Game {
    private Board board = new Board();
    private Player white = new Player(Constants.WHITE);
    private Player black = new Player(Constants.BLACK);

}