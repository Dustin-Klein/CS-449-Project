package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.gameLogic.pieces.Piece;

public class Move {

    private int sourceRow;
    private int sourceCol;
    private int destRow;
    private int destCol;

    private Piece piece;

    public Move(int sourceRow, int sourceCol, int destRow, int destCol, Piece piece) {
        this.sourceRow = sourceRow;
        this.sourceCol = sourceCol;
        this.destRow = destRow;
        this.destCol = destCol;
    }

    public int getSourceRow() {
        return sourceRow;
    }

    public int getSourceCol() {
        return sourceCol;
    }

    public int getDestRow() {
        return destRow;
    }

    public int getDestCol() {
        return destCol;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean equals(Move move2) {
        if (this == move2) return true;
        if (move2 == null) return false;
        if (this.getClass() != move2.getClass()) return false;

        return this.sourceRow == move2.getSourceRow() &&
                this.sourceCol == move2.getSourceCol() &&
                this.destRow == move2.getDestRow() &&
                this.destCol == move2.getDestCol();
    }

    @Override
    public String toString() {
        return "Move{" +
                "sourceRow=" + sourceRow +
                ", sourceCol=" + sourceCol +
                ", destRow=" + destRow +
                ", destCol=" + destCol +
                '}';
    }
}
