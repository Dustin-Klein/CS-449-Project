package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.PathTrace;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.bishop_white;
            case BLACK:
                return R.drawable.bishop_black;
            default:
                throw new Resources.NotFoundException("Color for bishop not found.");
        }
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
