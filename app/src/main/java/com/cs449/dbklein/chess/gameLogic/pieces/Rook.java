package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

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
    protected ArrayList<Move> getValidMoves(int sourceX, int sourceY, int destX, int destY, Board board) {
        return null;
    }
}
