package com.test.lesson18;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by USER on 21.12.2015.
 */
public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void init(Context context, AttributeSet attributeSet){
        if (isInEditMode())
        {
            return;
        }

        TypedArray a = context.obtainStyledAttributes(attributeSet,
                R.styleable.MyStyle);


        int customFont  !=

    }





}
