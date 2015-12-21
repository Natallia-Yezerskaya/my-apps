package com.test.myapplication;

import android.app.Application;
import android.util.Log;

public class MyApp extends Application {

    private static MyApp myApp;

    public static MyApp getInstance() {
        return myApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;

        Log.d("MyApp", "sdfdsfds");
    }
}
