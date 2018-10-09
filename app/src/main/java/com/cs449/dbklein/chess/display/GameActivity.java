package com.cs449.dbklein.chess.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Color;
import com.cs449.dbklein.chess.gameLogic.Pawn;
import com.cs449.dbklein.chess.gameLogic.PieceType;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView boardView = findViewById(R.id.chessboard_gridview);
        Board board = new Board();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.getCell(i, j).setPiece(new Pawn(PieceType.PAWN, Color.WHITE));
            }
        }
        ChessBoardAdapter chessBoardAdapter = new ChessBoardAdapter(this, board);
        boardView.setAdapter(chessBoardAdapter);
    }
}
