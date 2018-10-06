package com.cs449.dbklein.chess.gameLogic;

public class Cell {

    private Piece piece;
    private boolean occupied;

    public Cell() {
        piece = null;
        occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
