package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.gameLogic.pieces.Piece;

import java.util.ArrayList;

public class Board {

    private final int BOARD_WIDTH = 8;
    private final int BOARD_HEIGHT = 8;

    private Cell[][] board;

    Board() {
        board = new Cell[BOARD_WIDTH][BOARD_HEIGHT];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Cell();
                board[i][j].setRow(i);
                board[i][j].setCol(j);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public int getNumCol() {
        return BOARD_WIDTH;
    }

    public int getNumRow() {
        return BOARD_HEIGHT;
    }

    public boolean makeMove(Move move) {
        Cell sourceCell = board[move.getSourceRow()][move.getSourceCol()];
        Piece pieceToMove = sourceCell.getPiece();
        System.out.println("Requested Move: \n" + move.toString() + "\nPossible Moves: ");
        ArrayList<Move> possibleMoves = pieceToMove.getValidMoves(move.getSourceRow(), move.getSourceCol(), this);
        for (Move psm : possibleMoves) {
            System.out.println(psm.toString());
        }

        boolean isValidMove = false;
        for (Move possibleMove : possibleMoves) {
            if (move.equals(possibleMove))
                isValidMove = true;
        }
        return isValidMove;
    }

    public boolean inBounds(int pos) {
        return pos >= 0 && pos < BOARD_HEIGHT;
    }
}
