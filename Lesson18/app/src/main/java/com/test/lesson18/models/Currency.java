package com.test.lesson18.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 06.01.2016.
 */
public class Currency {
    @SerializedName("base")//TODO для примера
    private  String base;
    @SerializedName("date")
    private  String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
