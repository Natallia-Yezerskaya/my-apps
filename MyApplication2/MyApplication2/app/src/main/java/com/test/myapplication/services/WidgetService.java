package com.test.myapplication.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class WidgetService extends Service {

    public static final String ACTION = "action";
    public static final int ACTION_BT_ON_OFF = 1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        int action = intent.getIntExtra(ACTION, -1);
        Log.d("WidgetService", "onStartCommand, action = " + action);

        switch (action) {
            case ACTION_BT_ON_OFF:
                // тут логіка включенія/выключенія блютуза
                break;
        }





        return super.onStartCommand(intent, flags, startId);
    }

     @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
