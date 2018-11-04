package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

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
    protected ArrayList<Move> getValidMoves(int sourceX, int sourceY, int destX, int destY, Board board) {
        if (board.getCell(sourceX, sourceY).getPiece() != this)
            throw new IllegalArgumentException("Piece not matching up at cells");

        switch (color) {
            case WHITE:
                return null;
            case BLACK:
                return null;
            default:
                return null;
        }
    }
}
