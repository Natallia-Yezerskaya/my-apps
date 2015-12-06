package com.natallia.lesson9;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.*;

/**
 * Created by Administrator on 02.12.15.
 */
class PieChart extends View {

    private List<Paint>  mPiePaint = new ArrayList<Paint>();
    private List<Float> mData = new ArrayList<Float>();
    private RectF mBounds;
    public float animationPosition = 0f;

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        mData.add(30f);
        mData.add(30f);
        mData.add(30f);
        invalidate();
    }

    public List<Float> getData() {
        return mData;
    }

    public void setData(List<Float> mData) {
        this.mData = mData;
        invalidate();
    }

    private void init() {

        Paint mPiePaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint1.setStyle(Paint.Style.FILL);
        mPiePaint1.setColor(Color.RED);

        Paint mPiePaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint2.setStyle(Paint.Style.FILL);
        mPiePaint2.setColor(Color.BLUE);

        Paint mPiePaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPiePaint3.setStyle(Paint.Style.FILL);
        mPiePaint3.setColor(Color.GREEN);

        mPiePaint.add(mPiePaint1);
        mPiePaint.add(mPiePaint2);
        mPiePaint.add(mPiePaint3);

        for (int i = 0; i < 20; i++) {// если больше трех частей, генерируем цвета
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random()*255)));
            mPiePaint.add(p);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Account for padding
        float xpad = (float)(getPaddingLeft() + getPaddingRight());
        float ypad = (float)(getPaddingTop() + getPaddingBottom());

        float ww = (float)w - xpad;
        float hh = (float)h - ypad;

        // Figure out how big we can make the pie.
        float radius = Math.min(ww, hh) / 2f;

        mBounds = new RectF(w / 2f - radius,
                h / 2f - radius,
                w / 2f + radius,
                h / 2f + radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float animationAngle = 360 * animationPosition;
        float startAngle = 0f;
        float sum = 0f;
        boolean finish = false;
        for (int i = 0; i <mData.size() ; i++) {
            sum += mData.get(i);
        }

        for (int i = 0; i < mData.size(); i++) {
            float it = mData.get(i);
            float sweepAngle  = 360/sum*it;
            float endAngle = startAngle+sweepAngle;

            if (endAngle >= animationAngle)
            {
                endAngle = animationAngle;
                finish = true;
            }
            mPiePaint.get(i).setAlpha((int)(255*animationPosition)); // устанавливаем прозрачность

            canvas.drawArc(mBounds,
                    startAngle,
                    endAngle-startAngle,
                    true,  mPiePaint.get(i));
            startAngle += 360/sum*it;
            if (finish) {break;}
        }
        }

}