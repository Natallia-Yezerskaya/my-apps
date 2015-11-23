package com.test.myapplicationtest.models;

import java.util.Date;

/**
 * Created by USER on 18.11.2015.
 */
public class Summa {
    private double summa;
    private Date date;
    private String name;


    public Summa(double summa, Date date, String name) {
        this.summa = summa;
        this.date = date;
        this.name = name;
    }
    public void setSumma(double summa) {
        this.summa = summa;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSumma() {
        return summa;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }


}

