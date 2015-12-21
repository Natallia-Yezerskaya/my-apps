package com.test.myapplication.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.test.myapplication.R;
import com.test.myapplication.activities.MainActivity;

public class MyIntentService extends IntentService{

    public MyIntentService() {
        super("sdfdsf");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d("AsyncTask", "START WHILE");

        int i = 0;
        while(i < 5) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("AsyncTask", "onHandleIntent() " + i);
            i++;
        }

        Log.d("AsyncTask", "STOP WHILE");

        Intent intent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 123, intent1,
                        PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder
                = new NotificationCompat.Builder(this);
        notificationBuilder
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My APP")
                .setContentText("STOP WHILE")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent);

        NotificationManager manager
                = (NotificationManager)getSystemService
                (Context.NOTIFICATION_SERVICE);

        manager.notify(555, notificationBuilder.build());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("AsyncTask", "onDestroy()");
    }
}
