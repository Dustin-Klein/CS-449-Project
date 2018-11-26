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
    public ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board) {
        if (board.getCell(sourceRow, sourceCol).getPiece() != this)
            throw new IllegalStateException("Piece not matching up at cells");

        ArrayList<Move> validMoves = new ArrayList<>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    int destRow = sourceRow + i;
                    int destCol = sourceCol + j;

                    if (isValidDestination(destRow, destCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, destRow, destCol, this));
                }
            }
        }
        return validMoves;
    }

    protected boolean isValidDestination(int destRow, int destCol, Board board) {
        if (!board.inBounds(destRow, destCol))
            return false;

        if (board.getCell(destRow, destCol).isOccupied()) {
            return board.getCell(destRow, destCol).getPiece().getColor() != color;
        }

        return true;
    }
}
