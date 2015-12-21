package com.test.myapplication.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.test.myapplication.R;

public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs ) {

        if(isInEditMode()) {
            return;
        }

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyStyle);

        int customFont = a.getInt(R.styleable.MyStyle_my_font, -1);
        if(customFont != -1) {
            setCustom(context, customFont);

        }

        a.recycle();
    }

    public void setCustom(Context context, int fontEnum) {

        Typeface t;
        try {
            t = MyTypeface.get(context, fontEnum);
        } catch (Exception e) {
            Log.w("MyTextView", "Could not get typeface");
            return;
        }

        setTypeface(t);
        return;
    }

}
