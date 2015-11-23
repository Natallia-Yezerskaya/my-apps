package com.test.myapplicationtest;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity{

    private List<String> list = new ArrayList<>();
    private ListView mlistView;
    public static final String KEY_EDIT_TEXT = "KEY_EDIT_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list.add("элемент 1");
        list.add("элемент 2");
        list.add("элемент 3");
        list.add("элемент 4");
        list.add("элемент 5");
        list.add("элемент 6");
        list.add("элемент 7");
        list.add("элемент 8");
        list.add("элемент 9");
        list.add("элемент 10");
        list.add("элемент 11");
        list.add("элемент 12");
        mlistView = (ListView)findViewById(R.id.listView);

        MyAdapter myAdapter = new MyAdapter(this,list);
        mlistView.setAdapter(myAdapter);

        mlistView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


      }



}
