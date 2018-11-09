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
    public ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board) {
        return null;
    }

    @Override
    protected boolean isValidDestination(int destRow, int destCol, Board board) {
        return false;
    }
}
