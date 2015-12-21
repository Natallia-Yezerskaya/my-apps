package com.test.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private static final String TAG = DbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "mDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static class DoctorTable {
        private static final String TABLE_NAME = "doctors";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_AGE = "age";
    }

    private SQLiteDatabase mDatabase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "SUPER");

    }

    public void open() {
        if(mDatabase == null || !mDatabase.isOpen()) {
            this.mDatabase = getWritableDatabase();
        }
    }

    public void close() {
        if(mDatabase != null)mDatabase.close();
    }

    public void onCreate(SQLiteDatabase db) {

        Log.d(TAG, "onCreate");
        db.execSQL("CREATE TABLE '"+DoctorTable.TABLE_NAME+"' " +
                "('" +DoctorTable.COL_ID + "' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'"+DoctorTable.COL_NAME+"' TEXT, '"+DoctorTable.COL_AGE+"' INTEGER)"
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade");
    }

    public void  saveDoctors(String name, int age) {

        mDatabase.execSQL("INSERT INTO '"+DoctorTable.TABLE_NAME+
                        "' ('"+DoctorTable.COL_NAME+"'" +
                        ",'"+DoctorTable.COL_AGE+"') " +
                        "VALUES ('"+name+"', " + age + ")"
        );
    }

    public void  getDoctors() {

        Cursor cursor;
        cursor = mDatabase.query(DoctorTable.TABLE_NAME,
                                null, null, null, null, null, null);

        Log.d(TAG, "count" + cursor.getCount());

        if(cursor.moveToFirst()) {

            int i = 0;
            while(cursor.moveToNext()) {
                Log.d(TAG, "===========| " + i + "| =============");
                Log.d(TAG, "id = " + cursor.getInt(0));
                Log.d(TAG, "name = " + cursor.getString(1));
                Log.d(TAG, "age = " + cursor.getInt(2));
                i++;
            }
        } else {
            Log.d(TAG, "error with moveToFirst()");
        }
    }

}
