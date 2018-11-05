package com.cs449.dbklein.chess.gameLogic;

public class Move {

    private int sourceRow;
    private int sourceCol;
    private int destRow;
    private int destCol;

    public Move(int sourceRow, int sourceCol, int destRow, int destCol) {
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
