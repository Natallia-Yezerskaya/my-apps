package com.test.lesson_8_classwork;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.test.lesson_8_classwork.database.DBHelper;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper db = new DBHelper(this);
        db.saveDoctors("Doctor 1",25);
        db.saveDoctors("Doctor 2",30);
        db.saveDoctors("Doctor 3",40);



        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    db.getDoctors();



            }
        });










    }





}
