package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.gameLogic.pieces.Bishop;
import com.cs449.dbklein.chess.gameLogic.pieces.Color;
import com.cs449.dbklein.chess.gameLogic.pieces.EmptyPiece;
import com.cs449.dbklein.chess.gameLogic.pieces.King;
import com.cs449.dbklein.chess.gameLogic.pieces.Knight;
import com.cs449.dbklein.chess.gameLogic.pieces.Pawn;
import com.cs449.dbklein.chess.gameLogic.pieces.PieceType;
import com.cs449.dbklein.chess.gameLogic.pieces.Queen;
import com.cs449.dbklein.chess.gameLogic.pieces.Rook;

public class Game {

    public Game() {
        board = new Board();
        setupBoard();

        turn = Color.WHITE;
    }

    public Color getTurn() {
        return turn;
    }

    private Color turn;

    private Board board;

    public void switchTurn() {
        if (turn == Color.BLACK) {
            turn = Color.WHITE;
        } else if (turn == Color.WHITE) {
            turn = Color.BLACK;
        }
    }

    private void setupBoard() {

        //***** Black Pieces *****
        board.getCell(0, 0).setPiece(new Rook(Color.BLACK));
        board.getCell(0, 7).setPiece(new Rook(Color.BLACK));
        board.getCell(0, 1).setPiece(new Knight(Color.BLACK));
        board.getCell(0, 6).setPiece(new Knight(Color.BLACK));
        board.getCell(0, 2).setPiece(new Bishop(Color.BLACK));
        board.getCell(0, 5).setPiece(new Bishop(Color.BLACK));
        board.getCell(0, 3).setPiece(new Queen(Color.BLACK));
        board.getCell(0, 4).setPiece(new King(Color.BLACK));
        for (int i = 0; i < 8; i++) {
            board.getCell(1, i).setPiece(new Pawn(Color.BLACK));
        }

        //***** White Pieces *****
        board.getCell(7, 0).setPiece(new Rook(Color.WHITE));
        board.getCell(7, 7).setPiece(new Rook(Color.WHITE));
        board.getCell(7, 1).setPiece(new Knight(Color.WHITE));
        board.getCell(7, 6).setPiece(new Knight(Color.WHITE));
        board.getCell(7, 2).setPiece(new Bishop(Color.WHITE));
        board.getCell(7, 5).setPiece(new Bishop(Color.WHITE));
        board.getCell(7, 3).setPiece(new Queen(Color.WHITE));
        board.getCell(7, 4).setPiece(new King(Color.WHITE));
        for (int i = 0; i < 8; i++) {
            board.getCell(6, i).setPiece(new Pawn(Color.WHITE));
        }
        board.getCell(6, 4).setPiece(new EmptyPiece());
    }

    public Board getBoard() {
        return board;
    }

    public boolean isVictory() {
        boolean whiteVictory = true;
        boolean blackVictory = true;

        for (int row = 0; row < board.getNumRow(); row++) {
            for (int col = 0; col < board.getNumCol(); col++) {
                if (board.getCell(row, col).getPiece().getColor() == Color.WHITE) {
                    if (board.getCell(row, col).getPiece().getType() == PieceType.KING)
                        blackVictory = false;
                } else {
                    if (board.getCell(row, col).getPiece().getType() == PieceType.KING)
                        whiteVictory = false;
                }

            }
        }

        return whiteVictory || blackVictory;
    }
}
