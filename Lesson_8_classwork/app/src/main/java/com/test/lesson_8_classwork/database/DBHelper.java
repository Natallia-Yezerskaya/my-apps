package com.test.lesson_8_classwork.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by USER on 27.11.2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final  String TAG  = DBHelper.class.getSimpleName();
    private static final  String DATABASE_NAME  = "database.db";
    private static final  int DATABASE_VERSION  = 1;



    private static class DoctorTable{
        private static final String TABLE_NAME = "doctors";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "name";
        private static final String COL_AGE = "age";

    }

    private SQLiteDatabase mDatabase;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG,"super");
        this.mDatabase = getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL("CREATE TABLE '"+ DoctorTable.TABLE_NAME +"' ("+
                        DoctorTable.COL_ID  +"  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        DoctorTable.COL_NAME+" TEXT, " +
                        DoctorTable.COL_AGE + " INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpdate");
    }

    public void saveDoctors(String name, int age){

        mDatabase.execSQL("INSERT INTO '" + DoctorTable.TABLE_NAME +
                "' ('" + DoctorTable.COL_NAME + "', '" + DoctorTable.COL_AGE + "') VALUES ('" + name + "', '" + age + "')");
    }

    public void updateDoctors(String name, int age){

        String query = String.format("select %s, %s from %s where %s = ?",
                DoctorTable.COL_ID,
                DoctorTable.COL_NAME,
                DoctorTable.TABLE_NAME,
                DoctorTable.COL_NAME);
        Cursor cursor = mDatabase.rawQuery(query, new String[] {name});
        if (cursor.moveToNext()) {
                int id = cursor.getInt(cursor
                        .getColumnIndex(DoctorTable.COL_ID));

                String queryUpdate = String.format("UPDATE %s SET %s  = ?  where %s = ?",
                        DoctorTable.TABLE_NAME,
                        DoctorTable.COL_AGE,
                        DoctorTable.COL_ID);
                mDatabase.execSQL(queryUpdate,new Object[] {age, id});
                Log.i(TAG, "ROW " + id + " HAS age" + age);
            cursor.close();
        }
        else {
            saveDoctors(name, age);
        }
    }



    public void getDoctors(){
        Cursor cursor;
        cursor = mDatabase.query(DoctorTable.TABLE_NAME,
                null,null,null,null,null,null);
        int i = 0;
        Log.d(TAG,"count "+ cursor.getCount());
        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Log.d(TAG,"============|" + i +" | ===========");
                Log.d(TAG,"id "+cursor.getInt(cursor.getColumnIndex(DoctorTable.COL_ID)));
                Log.d(TAG,"name "+cursor.getString(1));
                Log.d(TAG,"age "+cursor.getInt(2));
                i++;
            }
        }
        else {
            Log.d(TAG,"error with moveToFirst");
        }
    }

}
