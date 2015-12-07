package com.test.lesson10_classwork.services;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.test.lesson10_classwork.MainActivity;
import com.test.lesson10_classwork.R;

/**
 * Created by USER on 07.12.2015.
 */
public class MyIntentService extends IntentService {
    public MyIntentService() {
        super("123");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // выполняется в дргуом потоке
        Log.d("IntentService"," START WHILE");
        int i = 0;
        while (i<5){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.d("IntentService", "onHandleIntent" + i);
            i++;
        }
        Log.d("IntentService"," STOP WHILE");



        Intent intent1 = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 123, intent1, PendingIntent.FLAG_ONE_SHOT); // позволяет запускать приложение из другого приложения

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My app")
                .setContentText("STOP WHILE")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
                ;

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(555,notificationBuilder.build());
       // manager.cancel(555); // закрыть, если пользователь уже зашел

    }

    @Override
    public void onDestroy() {

        Log.d("IntentService"," onDestroy");
    }
}
