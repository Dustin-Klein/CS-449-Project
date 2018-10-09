package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.R;

public class Pawn extends Piece {

    public Pawn(PieceType type, Color color) {
        super(type, color);
    }

    @Override
    public int getImageResource() {
        return R.drawable.gaming_pawn_icon;
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
