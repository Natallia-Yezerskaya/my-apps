package com.natallia.lesson9;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

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
                UpdateChart(editText,pieChart1);
                UpdateChart(editText2,pieChart2);
                UpdateChart(editText3,pieChart3);
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


}
