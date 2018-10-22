package com.cs449.dbklein.chess.gameLogic;

import com.cs449.dbklein.chess.gameLogic.pieces.Piece;

public class Move {

    private int sourceRow;
    private int sourceCol;
    private int destRow;
    private int destCol;

    private Piece piece;

    public Move(int sourceRow, int sourceCol, int destRow, int destCol, Piece piece) {
        this.sourceRow = sourceRow;
        this.sourceCol = sourceCol;
        this.destRow = destRow;
        this.destCol = destCol;

        this.piece = piece;
    }
}
