package com.test.myapplication.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyWidget extends View {

    public MyWidget(Context context) {
        super(context);
    }

    public MyWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyWidget(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {

        int w = getWidth();
        int h = getHeight();

//        Log.e("w", "w" + w);
//        Log.e("h", "h" + h);

        Paint paint = new Paint();
        paint.setStrokeWidth(52);
        paint.setStyle(Paint.Style.STROKE);


        RectF rect1 = new RectF(0, 0, w, h);
        canvas.drawRect(rect1, paint);



    }
}
