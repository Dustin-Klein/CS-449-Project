package com.cs449.dbklein.chess.display;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class ChessBoardView extends View {

    private static final int COLS = 8;
    private static final int ROWS = 8;
    private static final int DEF_SQUARE_SIZE = 50;
    private final Tile[][] mTiles;
    Tile tile;
    private Rect rect;
    private int x0 = 0;
    private int y0 = 0;
    private int squareSize = 0;
    private boolean flipped = false;

    public ChessBoardView(final Context context, AttributeSet attrs) {

        super(context, attrs);
        this.mTiles = new Tile[COLS][ROWS];
//        buildTiles();
        rect = new Rect();
    }

    protected void onDraw(final Canvas canvas) {
        int width = getWidth();

        int height = getHeight();
        squareSize = Math.min(getSquareSizeWidth(width), getSquareSizeHeight(height));
        computeOrigins(width, height);

        for (int c = 0; c < COLS; c++) {
            for (int r = 0; r < ROWS; r++) {
                final int xCoord = getXCoord(c);
                final int yCoord = getYCoord(r);

                mTiles[c][r].setTileRect(rect);

                rect.left = xCoord;
                rect.top = yCoord;
                rect.right = rect.left + squareSize;  // right
                rect.bottom = rect.top + squareSize;
                mTiles[c][r].draw(canvas);

            }
        }
    }

    protected void onMeasure(int widthMeasureSpec, int
            heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);

        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        int sqSizeW = getSquareSizeWidth(width);
        int sqSizeH = getSquareSizeHeight(height);
        int sqSize = Math.min(sqSizeW, sqSizeH);

        if (height > width) {
            int p = getMaxHeightPercentage();
            height = Math.min(getHeight(sqSize), height * p / 100);
        } else {
            width = Math.min(getWidth(sqSize), width * 65 / 100);

        }
        setMeasuredDimension(width, height);
    }

    protected int getWidth(int sqSize) {
        return sqSize * 8;
    }

    protected int getHeight(int sqSize) {
        return sqSize * 8;
    }

    private int getSquareSizeWidth(final int width) {
        return (width) / 8;
    }

    private int getSquareSizeHeight(final int height) {
        return (height) / 8;
    }

    private int getXCoord(final int x) {
        return x0 + squareSize * (flipped ? 7 - x : x);
    }

    private int getYCoord(final int y) {
        return y0 + squareSize * (flipped ? y : 7 - y);
    }

    private void computeOrigins(final int width, final int height) {
        this.x0 = (width - squareSize * 8) / 2;
        this.y0 = (height - squareSize * 8) / 2;
    }

    protected int getMaxHeightPercentage() {
        return 75;
    }
}