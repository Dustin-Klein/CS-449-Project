package com.cs449.dbklein.chess.gameLogic.pieces;

import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

public class EmptyPiece extends Piece {

    public EmptyPiece() {
        super(PieceType.EMPTY, Color.EMPTY);
    }

    @Override
    public int getImageResource() {
        return Integer.parseInt(null);
    }

    @Override
    public ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board) {
        return null;
    }
}
