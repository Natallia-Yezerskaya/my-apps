package com.test.myapplication.models;

import java.util.Comparator;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class Summa implements Comparable<Summa>{

    private double summa;
    private Date date;
    private String name;

    public Summa() {
    }

    public Summa(double summa, Date date, String name) {
        this.summa = summa;
        this.date = date;
        this.name = name;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Summa summa) {
        return Double.valueOf(summa.getSumma()).
                compareTo(this.summa);
    }

    public class MySummaComparator implements Comparator<Summa> {

        @Override
        public int compare(Summa summa, Summa t1) {
            int res;
            if (summa.getSumma() > t1.getSumma()) {
                res = 1;
            }
            else if (summa.getSumma() == t1.getSumma()) {
                res = 0;
            }
            else {
                res = -1;
            }

            return res;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Summa summa1 = (Summa) o;

        if (Double.compare(summa1.summa, summa) != 0) return false;
        if (date != null ? !date.equals(summa1.date) : summa1.date != null) return false;
        return !(name != null ? !name.equals(summa1.name) : summa1.name != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(summa);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
