package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.PathTrace;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.pawn_white;
            case BLACK:
                return R.drawable.pawn_black;
            default:
                throw new Resources.NotFoundException("Color for pawn not found.");
        }
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
