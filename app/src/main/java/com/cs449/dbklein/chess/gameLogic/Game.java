package com.cs449.dbklein.chess.gameLogic;

public class Game {

    private Board board;

    public Game() {
        board = new Board();
        setupBoard();
    }

    private void setupBoard() {
        for (int i = 0; i < 8; i++) {
            board.getCell(1, i).setPiece(new Pawn(Color.BLACK));
        }

        for (int i = 0; i < 8; i++) {
            board.getCell(6, i).setPiece(new Pawn(Color.WHITE));
        }
    }

    public Board getBoard() {
        return board;
    }
}
