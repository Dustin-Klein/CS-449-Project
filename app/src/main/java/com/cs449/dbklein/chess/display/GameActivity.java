package com.cs449.dbklein.chess.display;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Cell;
import com.cs449.dbklein.chess.gameLogic.Game;
import com.cs449.dbklein.chess.gameLogic.Move;

public class GameActivity extends AppCompatActivity {

    private Cell selectedCell = null;

    private Game game;
    private Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        game = new Game();
        board = game.getBoard();

        final ChessBoardAdapter chessBoardAdapter = new ChessBoardAdapter(this, game.getBoard());

        GridView boardView = findViewById(R.id.chessboard_gridview);
        boardView.setAdapter(chessBoardAdapter);
        boardView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                int row = position / 8;
                int col = position % 8;

                final Cell cell = board.getCell(row, col);

                if (!game.isVictory()) {
                    if (selectedCell != null) {
                        if (selectedCell == cell) {
                            cell.setSelected(false);
                            selectedCell = null;
                        } else {
                            if (board.makeMove(new Move(selectedCell.getRow(), selectedCell.getCol(), row, col, selectedCell.getPiece()))) {
                                game.switchTurn();

                                cell.setSelected(false);
                                selectedCell = null;
                            }
                        }
                    } else {
                        if (game.getTurn() == cell.getPiece().getColor()) {
                            if (cell.isOccupied()) {
                                cell.setSelected(true);
                                selectedCell = cell;
                            }
                        }
                    }
                } else {

                    System.out.println("Game Over");
//                    Context context = getApplicationContext();
//                    CharSequence text = "Game Over";
//                    int duration = Toast.LENGTH_LONG;
//
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();

                }


                // This tells the GridView to redraw itself
                chessBoardAdapter.notifyDataSetChanged();
            }
        });
    }
}
