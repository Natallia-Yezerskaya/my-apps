package com.test.lesson10_classwork.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by USER on 02.12.2015.
 */
public class MyService extends Service {


    private static final String TAG = MyService.class.getSimpleName();
    public static final String ACTION_MY = "com.test.lesson10_classwork.services.ACTION_MY";
    public static final String KEY_VALUE = "key_value";
    private boolean isStarted = true;
    private Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate");
        StartThread();
        mHandler = new Myhandler();
    }


    private class Myhandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d(TAG,"handlemessage" + msg.arg1); // передаем градус

            //TODO сделать  invalidate()
        }


    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
         Log.d(TAG,"onBind");
        return null;

    }


    @Override
    public boolean onUnbind(Intent intent) {

        Log.d(TAG,"onUnbind");
        return super.onUnbind(intent);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
        StopThread();
    }

    private void StartThread(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                int value = 0;
                while (isStarted){

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                   sendEvent(value);
                    Message message = new Message();
                    message.arg1 = 10;// передаем градус
                    mHandler.sendMessage(message);

                    mHandler.sendMessageDelayed(message,1000);  // отправка с зажержкой


                   value++;



                    if (value>10) stopSelf();// останавливаем поток
            }
            }
        } );

        thread.start();
       //TODO создать поток

    }
    private void StopThread(){
        //FIXME для ошибок

        isStarted = false;
    }

    private void  sendEvent(int value){

        Intent intent =  new Intent(ACTION_MY);
        intent.putExtra(KEY_VALUE,value);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

    }

}
