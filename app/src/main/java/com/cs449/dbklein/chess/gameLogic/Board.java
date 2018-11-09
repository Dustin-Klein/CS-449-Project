package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.gameLogic.pieces.EmptyPiece;
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
        boolean isValidMove = false;

        Cell sourceCell = board[move.getSourceRow()][move.getSourceCol()];
        Cell destCell = board[move.getDestRow()][move.getDestCol()];
        Piece pieceToMove = sourceCell.getPiece();

        ArrayList<Move> possibleMoves = pieceToMove.getValidMoves(move.getSourceRow(), move.getSourceCol(), this);
        for (Move possibleMove : possibleMoves) {
            if (move.equals(possibleMove))
                isValidMove = true;
        }

        if (isValidMove) {
            destCell.setPiece(pieceToMove);
            sourceCell.setPiece(new EmptyPiece());
        }

        return isValidMove;
    }

    public boolean inBounds(int row, int col) {
        return (row >= 0 && row < BOARD_HEIGHT) && (col >= 0 && col < BOARD_WIDTH);
    }
}
