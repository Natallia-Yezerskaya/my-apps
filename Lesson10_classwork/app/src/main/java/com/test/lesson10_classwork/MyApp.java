package com.test.lesson10_classwork;

import android.app.Application;
import android.util.Log;

/**
 * Created by USER on 04.12.2015.
 */
//TODO Создается этот файл практически всегда в приложении
public class MyApp extends Application {


    private static MyApp myApp;

    public static MyApp getInstance(){//TODO можно получить контекст MyApp.getInstance()
        return myApp;

    }

    @Override
    public void onCreate() {
        Log.d("onCreate111","onCreate111" );
        super.onCreate();
        MyApp.getInstance();
        myApp = this;
        //TODO здесь можно указать инициализацию чего-либо

    }
}
