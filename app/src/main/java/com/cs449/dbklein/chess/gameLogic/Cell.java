package com.cs449.dbklein.chess.gameLogic;

public class Cell {

    private Piece piece;
    private boolean occupied;

    private int rank;
    private int file;

    public Cell(int rank, int file) {
        piece = null;
        occupied = false;

        this.rank = rank;
        this.file = file;
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

    public void display() {
        if (occupied)
            piece.display(rank, file);
    }
}
