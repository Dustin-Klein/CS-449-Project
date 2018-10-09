package com.cs449.dbklein.chess.display;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cs449.dbklein.chess.gameLogic.Board;

public class ChessBoardAdapter extends BaseAdapter{

    private final Context mContext;
    private final Board board;

    public ChessBoardAdapter(Context mContext, Board board) {
        this.mContext = mContext;
        this.board = board;
    }

    @Override
    public int getCount() {
        int count = 0;

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(String.valueOf(position));
        return dummyTextView;
    }
}
