package com.cs449.dbklein.chess.gameLogic.pieces;

import com.cs449.dbklein.chess.gameLogic.PathTrace;

public abstract class Piece {

    protected PieceType type;
    protected Color color;

    Piece(PieceType type, Color color) {
        this.color = color;
        this.type = type;
    }

    public abstract int getImageResource();

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