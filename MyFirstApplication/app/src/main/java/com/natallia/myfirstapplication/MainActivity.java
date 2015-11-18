package com.natallia.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listView);

        ArrayList<String> values = new ArrayList<String>();

        values.add("item 1");
        values.add("item 2");
        values.add("item 3");
        values.add("item 4");
        values.add("item 5");
        values.add("item 6");
        values.add("item 7");
        values.add("item 8");
        values.add("item 9");
        values.add("item 10");
        values.add("item 11");
        values.add("item 12");
        values.add("item 13");
        values.add("item 14");
        values.add("item 1588");

        ArrayAdapter<String> adapter = new MyAdapter(this, values);
        listview.setAdapter(adapter);
        /*adapter.add("item 1");
        adapter.add("item 2");
        adapter.add("item 3");
        adapter.add("item 4");
        adapter.add("item 5");
        adapter.add("item 6");
        adapter.add("item 7");
        adapter.add("item 8");
        adapter.add("item 9");
        adapter.add("item 10");
        adapter.add("item 11");
        adapter.add("item 12");
        adapter.add("item 13");
        adapter.add("item 14");
        adapter.add("item 1588");*/


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click Item Number " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }



    }



