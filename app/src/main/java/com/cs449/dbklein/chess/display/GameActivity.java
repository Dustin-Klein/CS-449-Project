package com.cs449.dbklein.chess.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView boardView = findViewById(R.id.chessboard_gridview);
        Board board = new Board();
        ChessBoardAdapter chessBoardAdapter = new ChessBoardAdapter(this, board);
        boardView.setAdapter(chessBoardAdapter);
    }
}
