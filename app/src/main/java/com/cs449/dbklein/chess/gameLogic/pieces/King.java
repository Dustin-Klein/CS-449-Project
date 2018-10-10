package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.PathTrace;

public class King extends Piece {

    public King(Color color) {
        super(PieceType.KING, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.king_white;
            case BLACK:
                return R.drawable.king_black;
            default:
                throw new Resources.NotFoundException("Color for king not found.");
        }
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
