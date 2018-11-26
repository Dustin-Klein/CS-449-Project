package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

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
    public ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board) {
        if (board.getCell(sourceRow, sourceCol).getPiece() != this)
            throw new IllegalStateException("Piece not matching up at cells");

        ArrayList<Move> validMoves = new ArrayList<>();

        // Up and Left
//        for (int i = Math.min(sourceRow, sourceCol); i >= 0; i--) {
//            System.out.println((sourceRow - i) + "," + (sourceCol - i));
//        }
        // Up and Right
//        for (int i = Math.min(sourceRow, 8 - sourceCol); i >= 0; i--) {
//            System.out.println((sourceRow - i) + "," + (sourceCol + i));
//        }

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (isValidDestination(sourceRow, sourceCol, i, j, board)) {
                    validMoves.add(new Move(sourceRow, sourceCol, i, j, this));
                }
            }
        }
        System.out.println(validMoves);

        return validMoves;
    }

    private boolean isValidDestination(int sourceRow, int sourceCol, int destRow, int destCol, Board board) {
        return board.inBounds(destRow, destCol);
    }
}
