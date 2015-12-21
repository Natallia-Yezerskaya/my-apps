package com.test.myapplication.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.HashMap;
import java.util.Hashtable;

public class MyTypeface {

    public static final int Quicksand_Bold = 0;
    public static final int Quicksand_Italic = 1;

    private static class FontHashMap extends HashMap<Integer, String> {
        {
            put(Quicksand_Bold, "Quicksand-Bold.otf");
            put(Quicksand_Italic, "Quicksand-Italic.otf");
        }
    }
    private static final HashMap<Integer, String> fontHashMap
            = new FontHashMap();

    private static final Hashtable<String, Typeface> cash = new Hashtable<>();

    public static Typeface get(Context context, String assetPath) {

        synchronized (cash) {
            if(!cash.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(context.getAssets(),
                            assetPath);
                    cash.put(assetPath, t);
                } catch (Exception e) {
                    Log.w("MyTypeface",
                            "Could not get typeface " + assetPath);
                    return null;
                }
            }

            return cash.get(assetPath);
        }
    }

    public static Typeface get(Context context, int fontEnum) {

        String name = fontHashMap.get(fontEnum);
        if(name == null) {
            throw  new IllegalArgumentException("Could not get typeface");
        }

        return get(context, "fonts/" + name);
    }

}
