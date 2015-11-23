package com.test.myapplicationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by USER on 11.11.2015.
 */
public class SecondActivity extends Activity {
    public static final String KEY_TEXT = "key_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView textView = (TextView) findViewById(R.id.editText);

        Intent intent = getIntent();
        String text = intent.getStringExtra(KEY_TEXT);
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }



    }
}
