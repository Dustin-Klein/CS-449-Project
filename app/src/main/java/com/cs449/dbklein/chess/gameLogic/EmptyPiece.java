package com.cs449.dbklein.chess.gameLogic;

public class EmptyPiece extends Piece {

    public EmptyPiece() {
        super(PieceType.EMPTY, Color.EMPTY);
    }

    @Override
    public int getImageResource() {
        return Integer.parseInt(null);
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
