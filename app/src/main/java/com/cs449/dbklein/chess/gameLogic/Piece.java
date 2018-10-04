package com.cs449.dbklein.chess.gameLogic;

public abstract class Piece {

    protected Color color;
    protected int rank, file;

    public Piece(Color color, int rank, int file) {
        this.color = color;

        this.rank = rank;
        this.file = file;
    }

    protected abstract void moveTo();

    protected abstract boolean isValidMove(int toRank, int toFile);
}
