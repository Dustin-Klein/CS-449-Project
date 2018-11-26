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
        if (board.getCell(sourceRow, sourceCol).getPiece() != this)
            throw new IllegalStateException("Piece not matching up at cells");

        ArrayList<Move> validMoves = new ArrayList<>();

        // Check every cell in the column
        for (int row = 0; row < board.getNumRow(); row++) {
            if (isValidDestination(sourceRow, sourceCol, row, sourceCol, board))
                validMoves.add(new Move(sourceRow, sourceCol, row, sourceCol, this));
        }

        // Check every cell in the row
        for (int col = 0; col < board.getNumCol(); col++) {
            if (isValidDestination(sourceRow, sourceCol, sourceRow, col, board))
                validMoves.add(new Move(sourceRow, sourceCol, sourceRow, col, this));
        }

        return validMoves;
    }

    private boolean isValidDestination(int sourceRow, int sourceCol, int destRow, int destCol, Board board) {
        if (!board.inBounds(destRow, destCol))
            return false;

        if (board.getCell(destRow, destCol).getPiece().getColor() == color)
            return false;

        // Attempt to move to the same cell
        if (sourceRow == destRow && sourceCol == destCol)
            return false;

        // Collision detection
        if (sourceRow == destRow) {
            // Horizontal move
            if (sourceCol < destCol) {
                // Move right
                for (int i = sourceCol + 1; i < destCol; ++i)
                    if (board.getCell(sourceRow, i).isOccupied())
                        return false;

                if (board.getCell(destRow, destCol).isOccupied())
                    return board.getCell(destRow, destCol).getPiece().getColor() != color;
            } else {
                // Move left
                for (int i = sourceCol - 1; i > destCol; --i)
                    if (board.getCell(sourceRow, i).isOccupied())
                        return false;

                if (board.getCell(destRow, destCol).isOccupied())
                    return board.getCell(destRow, destCol).getPiece().getColor() != color;
            }
        } else if (sourceCol == destCol) {
            // Vertical move
            if (sourceRow < destRow) {
                // Move down
                for (int i = sourceRow + 1; i < destRow; ++i)
                    if (board.getCell(i, sourceCol).isOccupied())
                        return false;

                if (board.getCell(destRow, destCol).isOccupied())
                    return board.getCell(destRow, destCol).getPiece().getColor() != color;
            } else {
                // Move up
                for (int i = sourceRow - 1; i > destRow; --i)
                    if (board.getCell(i, sourceCol).isOccupied())
                        return false;

                if (board.getCell(destRow, destCol).isOccupied())
                    return board.getCell(destRow, destCol).getPiece().getColor() != color;
            }
        } else {
            // Not a valid rook move (neither horizontal nor vertical)
            return false;
        }

        return true;
    }
}
