package com.cs449.dbklein.chess.gameLogic;

public class Board {

    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;

    private Cell[][] board;

    public Board() {
        board = new Cell[BOARD_WIDTH][BOARD_HEIGHT];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int rank, int file) {
        return board[rank][file];
    }

    public int getNumCol() {
        return BOARD_WIDTH;
    }

    public int getNumRow() {
        return BOARD_HEIGHT;
    }
}
