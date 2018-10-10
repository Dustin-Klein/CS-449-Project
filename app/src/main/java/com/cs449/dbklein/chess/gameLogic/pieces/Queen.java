package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.PathTrace;

public class Queen extends Piece {

    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.queen_white;
            case BLACK:
                return R.drawable.queen_black;
            default:
                throw new Resources.NotFoundException("Color for queen not found.");
        }
    }

    @Override
    protected PathTrace tracePaths(int sourceX, int sourceY, int destX, int destY) {
        return null;
    }
}
