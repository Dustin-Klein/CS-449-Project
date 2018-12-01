package com.cs449.dbklein.chess.gameLogic.pieces;

import android.content.res.Resources;
import android.util.Pair;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Move;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public int getImageResource() {
        switch (color) {
            case WHITE:
                return R.drawable.queen_white;
            case BLACK:
                return R.drawable.queen_black;
            default:
                throw new Resources.NotFoundException("Color for queen not found.");
        }
    }

    @Override
    public ArrayList<Move> getValidMoves(final int sourceRow, final int sourceCol, Board board) {

        if (board.getCell(sourceRow, sourceCol).getPiece() != this)
            throw new IllegalStateException("Piece not matching up at cells");

        ArrayList<Move> validMoves = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> possibleDest = new ArrayList<>();

        // Find possible diagonal destinations
        for (int dx : new int[]{-1, 1})
            for (int dy : new int[]{-1, 1})
                possibleDest.addAll(getPossibleDestinations(sourceRow, sourceCol, dx, dy));

        // Find the possible horizontal and vertical directions
        for (int row = 0; row < board.getNumRow(); row++) {
            possibleDest.add(new Pair<>(row, sourceCol));
        }
        for (int col = 0; col < board.getNumCol(); col++) {
            possibleDest.add(new Pair<>(sourceRow, col));
        }


        for (Pair<Integer, Integer> dest : possibleDest) {
            Move possibleMove = new Move(sourceRow, sourceCol, dest.first, dest.second, this);

            if (!validMoves.contains(possibleMove))
                if (isValidDestination(sourceRow, sourceCol, dest.first, dest.second, board))
                    validMoves.add(possibleMove);
        }

        return validMoves;
    }

    private boolean isValidDestination(int sourceRow, int sourceCol, int destRow, int destCol, Board board) {
        if (!board.inBounds(destRow, destCol))
            return false;

        if (board.getCell(destRow, destCol).getPiece().getColor() == color)
            return false;

        if (Math.abs(sourceRow - destRow) == Math.abs(sourceCol - destCol)) {
            int dr = sourceRow < destRow ? 1 : -1;
            int dc = sourceCol < destCol ? 1 : -1;

            // Check every cell in between the source and destination
            int col = sourceCol + dc;
            for (int row = sourceRow + dr; row != destRow; row += dr) {

                if (board.getCell(row, col).isOccupied())
                    return false;

                col += dc;
            }
        } else if (sourceRow == destRow) {
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
            System.out.println("Should never get here");
            return false;
        }

        return true;
    }

    private ArrayList<Pair<Integer, Integer>> getPossibleDestinations(int sourceRow, int sourceCol, int dr, int dc) {
        ArrayList<Pair<Integer, Integer>> possibleDest = new ArrayList<>();

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
