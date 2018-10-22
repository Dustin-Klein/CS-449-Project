package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

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
    protected ArrayList<Move> getValidMoves(int sourceX, int sourceY, int destX, int destY, Board board) {
        return null;
    }
}
