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

    @Override
    public boolean equals(Object move2) {
        Move otherMove = (Move) move2;

        if (this == otherMove) return true;
        if (otherMove == null) return false;
        if (this.getClass() != otherMove.getClass()) return false;

        return this.sourceRow == otherMove.getSourceRow() &&
                this.sourceCol == otherMove.getSourceCol() &&
                this.destRow == otherMove.getDestRow() &&
                this.destCol == otherMove.getDestCol();
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
