package com.cs449.dbklein.chess.display;

import android.content.Context;
import android.util.AttributeSet;

public class ChessCellImageView extends android.support.v7.widget.AppCompatImageView {
    public ChessCellImageView(Context context) {
        super(context);
    }

    public ChessCellImageView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec); // This is the key that will make the height equivalent to its width
    }
}
