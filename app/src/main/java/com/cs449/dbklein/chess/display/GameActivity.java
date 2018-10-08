package com.cs449.dbklein.chess.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageButton;

import com.cs449.dbklein.chess.R;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GridView boardView = findViewById(R.id.chessboard_gridview);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ImageButton ib = new ImageButton(this);
                ib.setImageResource(R.drawable.gaming_pawn_icon);
                boardView.addView(ib);
            }
        }
    }
}
