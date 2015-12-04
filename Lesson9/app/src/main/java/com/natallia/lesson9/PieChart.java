package com.natallia.lesson9;

import android.content.ClipData;
import android.content.Context;
import android.graphics.BlurMaskFilter;
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

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);



        init();
        //mBounds = new RectF(700,100,800,150);

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

        for (int i = 0; i < 20; i++) {
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.argb(255, (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random()*255)));
            mPiePaint.add(p);
        }
       // mPiePaint.setTextSize(mTextHeight);


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

        float xAngle = 0f;
        float sum = 0f;
        for (int i = 0; i <mData.size() ; i++) {
            sum += mData.get(i);
        }
            // Draw the pie slices
            for (int i = 0; i < mData.size(); i++) {
                float it = mData.get(i);


                //mPiePaint.setShader;
                canvas.drawArc(mBounds,
                        xAngle,
                        360/sum*it,
                        true, mPiePaint.get(i));
                xAngle += 360/sum*it;
            }

        }

}