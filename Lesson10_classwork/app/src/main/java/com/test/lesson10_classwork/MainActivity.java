package com.test.lesson10_classwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.test.lesson10_classwork.services.MyService;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter =  new IntentFilter();
        filter.addAction(MyService.ACTION_MY) ; // устанавливаем фильтр
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,filter);
        startService(new Intent(this, MyService.class));

    }

    @Override
    protected void onStop() {
        super.onStop();
       stopService(new Intent(this,MyService.class));
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int value = intent.getIntExtra(MyService.KEY_VALUE,0);

            Toast.makeText(MainActivity.this, "value =" + value,Toast.LENGTH_SHORT).show();
        }
    };
}
