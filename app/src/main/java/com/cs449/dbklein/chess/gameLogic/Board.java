package com.cs449.dbklein.chess.gameLogic;

public class Board {

    private Cell[][] board;

    public Board() {
        board = new Cell[8][8];
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j].display();
            }
        }
    }
}
