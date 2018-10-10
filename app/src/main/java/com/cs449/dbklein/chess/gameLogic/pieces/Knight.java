package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.PathTrace;

public class Knight extends Piece {

    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.knight_white;
            case BLACK:
                return R.drawable.knight_black;
            default:
                throw new Resources.NotFoundException("Color for knight not found.");
        }
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
