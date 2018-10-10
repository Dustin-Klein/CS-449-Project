package com.cs449.dbklein.chess.display;

import android.annotation.SuppressLint;
import android.content.Context;
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
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

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

        final ImageView imageView = convertView.findViewById(R.id.cell);

        if (cell.isOccupied())
            imageView.setImageResource(cell.getPiece().getImageResource());

        return convertView;
    }
}
