package com.cs449.dbklein.chess.display;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ChessCellView extends RelativeLayout {
    public ChessCellView(Context context) {
        super(context);
    }

    public ChessCellView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
