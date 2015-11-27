package com.natallia.lesson7_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text1 = (TextView) findViewById(R.id.textView1);
        final TextView text2 = (TextView) findViewById(R.id.textView2);
        final TextView text3 = (TextView) findViewById(R.id.textView3);

    }


    @Override
    public void onClick(final View v) {
        final MyDialogFragment myDialogFragment = new MyDialogFragment();

        myDialogFragment.activity = this;
        myDialogFragment.onCreateDialog(null).show();

        myDialogFragment.mListener = new MyDialogFragment.NoticeDialogListener() {
            @Override
            public void onDialogPositiveClick(DialogFragment dialog) {
                Resources res = getResources();
                String[] days = res.getStringArray(R.array.Days);

                StringBuilder state = new StringBuilder();
                if (MyDialogFragment.mSelectedItems.size() == 0){
                    state = new StringBuilder("");}
                else{
                for (int i = 0; i < MyDialogFragment.mSelectedItems.size(); i++) {
                    state.append(" " + days[(Integer) MyDialogFragment.mSelectedItems.get(i)]);

                }}

                    TextView textview = (TextView) v;

                    textview.setText(state);
            }


            @Override
            public void onDialogNegativeClick(DialogFragment dialog) {

            }

        };

    }
}
