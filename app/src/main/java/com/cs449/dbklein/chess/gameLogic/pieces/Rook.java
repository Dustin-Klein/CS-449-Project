package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.PathTrace;

public class Rook extends Piece {

    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.rook_white;
            case BLACK:
                return R.drawable.rook_black;
            default:
                throw new Resources.NotFoundException("Color for rook not found.");
        }
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
