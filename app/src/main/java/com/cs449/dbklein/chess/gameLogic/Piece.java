package com.cs449.dbklein.chess.gameLogic;

public abstract class Piece {

    protected PieceType type;
    protected Color color;

    public Piece(PieceType type, Color color) {
        this.color = color;
        this.type = type;
    }

    public void display(int rank, int file) {

    }

    protected abstract PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY);

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
