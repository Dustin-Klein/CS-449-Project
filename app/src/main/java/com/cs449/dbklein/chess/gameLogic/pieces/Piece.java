package com.cs449.dbklein.chess.gameLogic.pieces;

import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

public abstract class Piece {

    protected PieceType type;
    protected Color color;

    Piece(PieceType type, Color color) {
        this.color = color;
        this.type = type;
    }

    public abstract int getImageResource();

    public abstract ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board);

//    public abstract boolean isValidDestination(int sourceRow, int sourceCol, int destRow, int destCol, Board board);

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

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", \tcolor=" + color +
                '}';
    }
}
