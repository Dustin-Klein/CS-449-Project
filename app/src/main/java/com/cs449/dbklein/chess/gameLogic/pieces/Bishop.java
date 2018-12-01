package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;
import android.util.Pair;

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
        ArrayList<Pair> possibleDest = new ArrayList<>();

        for (int dx : new int[]{-1, 1})
            for (int dy : new int[]{-1, 1})
                possibleDest.addAll(getPossibleDestinations(sourceRow, sourceCol, dx, dy));


        for (Pair dest : possibleDest) {
            if (isValidDestination(sourceRow, sourceCol, (int) dest.first, (int) dest.second, board))
                validMoves.add(new Move(sourceRow, sourceCol, (int) dest.first, (int) dest.second, this));
        }

        return validMoves;
    }

    private boolean isValidDestination(int sourceRow, int sourceCol, int destRow, int destCol, Board board) {
        if (!board.inBounds(destRow, destCol))
            return false;

        if (board.getCell(destRow, destCol).getPiece().getColor() == color)
            return false;

        if (sourceRow == destRow && sourceCol == destCol)
            return false;

        int dr = sourceRow < destRow ? 1 : -1;
        int dc = sourceCol < destCol ? 1 : -1;

        // Check every cell in between the source and destination
        int col = sourceCol + dc;
        for (int row = sourceRow + dr; row != destRow; row += dr) {

            if (board.getCell(row, col).isOccupied())
                return false;

            col += dc;
        }

        return true;
    }

    /**
     * Returns a list of all possible destinations on the diagonals of the bishop.
     * This does not verify that every one of these destinations are valid.
     */
    private ArrayList<Pair> getPossibleDestinations(int sourceRow, int sourceCol, int dr, int dc) {
        ArrayList<Pair> possibleDest = new ArrayList<>();

        for (int i = 1; i < 8; i++) {

            int destRow = sourceRow + dr * i;
            int destCol = sourceCol + dc * i;

            if (0 <= destRow && destRow < 8 && 0 <= destCol && destCol < 8)
                possibleDest.add(new Pair<>(destRow, destCol));
            else
                break;
        }

        return possibleDest;
    }
}
