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

    public Piece getPiece() {
        if (occupied)
            return piece;
        else
            return null;
    }
}
