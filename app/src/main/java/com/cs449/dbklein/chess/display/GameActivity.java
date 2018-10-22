package com.cs449.dbklein.chess.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Cell;
import com.cs449.dbklein.chess.gameLogic.Game;

public class GameActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = new Game();

        final ChessBoardAdapter chessBoardAdapter = new ChessBoardAdapter(this, game.getBoard());

        GridView boardView = findViewById(R.id.chessboard_gridview);
        boardView.setAdapter(chessBoardAdapter);
        boardView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                int row = position / 8;
                int col = position % 8;

                final Cell cell = game.getBoard().getCell(row, col);

                if (cell.isOccupied()) {
                    System.out.println(cell.getPiece().toString() + " at " + row + "," + col);
                }

                // This tells the GridView to redraw itself
                chessBoardAdapter.notifyDataSetChanged();
            }
        });
    }
}
