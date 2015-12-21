package com.test.myapplication;

import android.content.Context;

public class Manger {

    Context context;

    public Manger(Context context) {
            this.context = context;
    }

    public Manger() {
        this.context = MyApp.getInstance();
    }
}
