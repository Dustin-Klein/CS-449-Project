package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.R;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color);
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
