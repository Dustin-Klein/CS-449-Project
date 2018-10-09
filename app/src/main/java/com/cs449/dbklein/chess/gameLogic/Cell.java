package com.cs449.dbklein.chess.gameLogic;

public class Cell {

    private Piece piece;

    Cell() {
        piece = new EmptyPiece();
    }

    public boolean isOccupied() {
        return piece.getType() != PieceType.EMPTY;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
