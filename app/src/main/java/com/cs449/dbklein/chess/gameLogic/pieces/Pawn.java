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
    public ArrayList<Move> getValidMoves(int sourceRow, int sourceCol, Board board) {
        if (board.getCell(sourceRow, sourceCol).getPiece() != this)
            throw new IllegalStateException("Piece not matching up at cells");

        ArrayList<Move> validMoves = new ArrayList<>();

        switch (color) {
            case WHITE:
                if (sourceRow == 6) {
                    if (isValidDestination(sourceRow - 1, sourceCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 1, sourceCol, this));
                    if (isValidDestination(sourceRow - 2, sourceCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 2, sourceCol, this));
                } else {
                    if (isValidDestination(sourceRow - 1, sourceCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, sourceRow - 1, sourceCol, this));
                }
                return validMoves;
            case BLACK:
                if (sourceRow == 1) {
                    if (isValidDestination(sourceRow + 1, sourceCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 1, sourceCol, this));
                    if (isValidDestination(sourceRow + 2, sourceCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 2, sourceCol, this));
                } else {
                    if (isValidDestination(sourceRow + 1, sourceCol, board))
                        validMoves.add(new Move(sourceRow, sourceCol, sourceRow + 1, sourceCol, this));
                }
                return validMoves;
            default:
                throw new IllegalStateException("Pawn is neither Black or White");
        }
    }

    @Override
    protected boolean isValidDestination(int destRow, int destCol, Board board) {
        if (!board.inBounds(destRow, destCol))
            return false;

        return !board.getCell(destRow, destCol).isOccupied();
    }
}
