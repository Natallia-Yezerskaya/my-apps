package com.test.myapplication.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.test.myapplication.R;
import com.test.myapplication.models.Summa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity  {

    private TextView mTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout fr = (FrameLayout)findViewById(R.id.myframelayout);
        fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

       // mTextView = (TextView) findViewById(R.id.textView3);

       // Typeface t = Typeface.createFromAsset(this.getAssets(),
        //        "fonts/Quicksand-Bold.otf");

       // mTextView.setTypeface(t);
    }





}

