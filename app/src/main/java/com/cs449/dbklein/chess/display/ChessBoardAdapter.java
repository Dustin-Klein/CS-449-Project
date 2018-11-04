package com.cs449.dbklein.chess.display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.cs449.dbklein.chess.R;
import com.cs449.dbklein.chess.gameLogic.Board;
import com.cs449.dbklein.chess.gameLogic.Cell;

public class ChessBoardAdapter extends BaseAdapter {

    private final Context mContext;
    private final Board board;

    ChessBoardAdapter(Context mContext, Board board) {
        this.mContext = mContext;
        this.board = board;
    }

    @Override
    public int getCount() {
        return board.getNumCol() * board.getNumRow();
    }

    @Override
    public Object getItem(int position) {
        int row = position / 8;
        int col = position % 8;

        return board.getCell(row, col);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int row = position / 8;
        int col = position % 8;

        final Cell cell = board.getCell(row, col);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.cell_layout, null);
        }

        if (cell.isOccupied()) {
            ImageView cellImageView = convertView.findViewById(R.id.cell);
            cellImageView.setImageResource(cell.getPiece().getImageResource());

            if (cell.isSelected()) {
                System.out.println(cell.getPiece().toString() + " should be green");
                ImageView selectedImageView = convertView.findViewById(R.id.cell);
                selectedImageView.setImageResource(R.drawable.green_square);
                selectedImageView.setImageAlpha(100);
            }
        }
        return convertView;
    }
}
