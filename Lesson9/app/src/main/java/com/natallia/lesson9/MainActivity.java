package com.natallia.lesson9;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private boolean isStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button)findViewById(R.id.button);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        final EditText editText3 = (EditText)findViewById(R.id.editText3);
        final PieChart pieChart1 = (PieChart)findViewById(R.id.piechart1);
        final PieChart pieChart2 = (PieChart)findViewById(R.id.piechart2);
        final PieChart pieChart3 = (PieChart)findViewById(R.id.piechart3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateChart(editText, pieChart1);
                UpdateChart(editText2, pieChart2);
                UpdateChart(editText3, pieChart3);
                StartThread(pieChart1);
                StartThread(pieChart2);
                StartThread(pieChart3);
            }

        });
    }

        public void UpdateChart(EditText editText, PieChart pieChart){
            String text = editText.getText().toString();
            String mas[] = text.split(" ");
            List<Float> masFloat = new ArrayList<Float>();
            for (int i = 0; i < mas.length; i++) {
                try {
                    masFloat.add(Float.parseFloat(mas[i]));
                } catch (NumberFormatException e) {

                }
            }
            pieChart.setData(masFloat);
        }


    private void StartThread(final PieChart pieChart){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                float value = 0f;
                while (true){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    value += 0.002f;
                    pieChart.animationPosition = value; // передаем новый угол

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pieChart.invalidate(); // перерисовываем pieChart
                        }
                    });

                    if (value > 1f) break; // останавливаем поток
                }
            }
        } );
        thread.start();
    }

}
