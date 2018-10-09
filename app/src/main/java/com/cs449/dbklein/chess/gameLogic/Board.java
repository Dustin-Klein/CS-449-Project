package com.cs449.dbklein.chess.gameLogic;

public class Board {

    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;

    private Cell[][] board;

    public Board() {
        board = new Cell[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public Cell getCell(int rank, int file) {
        return board[rank][file];
    }

    public void displayBoard() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                board[i][j].display();
            }
        }
    }

    public int getWidth() {
        return BOARD_WIDTH;
    }

    public int getHeight() {
        return BOARD_HEIGHT;
    }
}
