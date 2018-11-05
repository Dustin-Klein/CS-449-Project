package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.gameLogic.pieces.EmptyPiece;
import com.cs449.dbklein.chess.gameLogic.pieces.Piece;
import com.cs449.dbklein.chess.gameLogic.pieces.PieceType;

public class Cell {

    private Piece piece;
    private boolean selected;

    private int row;
    private int col;

    Cell() {
        piece = new EmptyPiece();
        selected = false;
    }

    public boolean isOccupied() {
        return piece.getType() != PieceType.EMPTY;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
