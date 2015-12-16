package com.test.lesson15.services;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by USER on 16.12.2015.
 */
public class MyService extends Service {

    public static final  String ACTION = "action";
    public static final  int ACTION_BT_ON_OFF= 1;
    public static final  int ACTION_WF= 2;


    public  final BluetoothAdapter mBluetoothAdapter =  BluetoothAdapter.getDefaultAdapter();

    @Override
    public void onCreate() {
        super.onCreate();



    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        int action = intent.getIntExtra(ACTION, -1);

        Log.d("Widget"," on start command, action "+ action);
        switch (action){
            case ACTION_BT_ON_OFF:


                //TODO логика включения выклбчения блютуз


                if (!mBluetoothAdapter.isEnabled()) {

                    mBluetoothAdapter.enable();
                }
                else
                {
                    mBluetoothAdapter.disable();
                }



                break;

            case ACTION_WF:


                //TODO логика включения выклбчения блютуз

                WifiManager wifi = (WifiManager)
                        getSystemService(Context.WIFI_SERVICE);

                if (!wifi.isWifiEnabled()) {

                    wifi.setWifiEnabled(true);
                }
                else
                {
                    wifi.setWifiEnabled(false);
                }



                break;

        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
