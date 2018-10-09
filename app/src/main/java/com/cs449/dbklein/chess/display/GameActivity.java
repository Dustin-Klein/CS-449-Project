package com.cs449.dbklein.chess.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Game;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView boardView = findViewById(R.id.chessboard_gridview);
        ChessBoardAdapter chessBoardAdapter = new ChessBoardAdapter(this, new Game().getBoard());
        boardView.setAdapter(chessBoardAdapter);
    }
}
