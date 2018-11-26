package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.knight_white;
            case BLACK:
                return R.drawable.knight_black;
            default:
                throw new Resources.NotFoundException("Color for knight not found.");
        }
    }

    @Override
    public ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board) {
        if (board.getCell(sourceRow, sourceCol).getPiece() != this)
            throw new IllegalStateException("Piece not matching up at cells");

        ArrayList<Move> validMoves = new ArrayList<>();

        // Up and left
        if (isValidDestination(sourceRow - 1, sourceCol - 2, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 1, sourceCol - 2, this));
        if (isValidDestination(sourceRow - 2, sourceCol - 1, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 2, sourceCol - 1, this));
        // Up and right
        if (isValidDestination(sourceRow - 1, sourceCol + 2, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 1, sourceCol + 2, this));
        if (isValidDestination(sourceRow - 2, sourceCol + 1, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 2, sourceCol + 1, this));
        // Down and left
        if (isValidDestination(sourceRow + 1, sourceCol - 2, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 1, sourceCol - 2, this));
        if (isValidDestination(sourceRow + 2, sourceCol - 1, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 2, sourceCol - 1, this));
        // Down and right
        if (isValidDestination(sourceRow + 1, sourceCol + 2, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 1, sourceCol + 2, this));
        if (isValidDestination(sourceRow + 2, sourceCol + 1, board))
            validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 2, sourceCol + 1, this));

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
