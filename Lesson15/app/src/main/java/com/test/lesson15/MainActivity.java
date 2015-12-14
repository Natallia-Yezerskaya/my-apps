package com.test.lesson15;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Selection;
import android.util.Log;

import java.net.URI;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int LOADER_ID = 123;


    private String[] mProjection = new String []{
       // ContactsContract.Profile._ID,
        //ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
       // ContactsContract.Profile.LOOKUP_KEY,
       // ContactsContract.Profile.PHOTO_THUMBNAIL_URI};
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

             // getContentResolver().query(                                 // loader можно запустить в сервисе
            //              ContactsContract.Profile.CONTENT_URI,           //TODO URI.parse.("content:com.test.adsamf") в манифесте прописать пермишн

            //    mProjection, null, null, null);

        addEventToCalendar();
        getSupportLoaderManager().initLoader(LOADER_ID, null, this);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {

        return  new CursorLoader(this,ContactsContract.Contacts.CONTENT_URI,mProjection, null,null,ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {

        Log.d("RESULT","cursor "+cursorLoader.dataToString(cursor));
        cursor.moveToFirst();
        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
        Log.d("RESULT","name "+ name);



    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        Log.d("ddd","onLoaderReset()");
    }



    private void addEventToCalendar(){

        ContentResolver cr = getContentResolver();


        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART,System.currentTimeMillis()+10000);
        values.put(CalendarContract.Events.DTEND,System.currentTimeMillis()+20000);
        values.put(CalendarContract.Events.TITLE,"HELLOOOOOO");
        values.put(CalendarContract.Events.DESCRIPTION,"TODO");
        values.put(CalendarContract.Events.CALENDAR_ID,1);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());

        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI,values);

        Log.d("gasjdgj","event_id" + Long.parseLong(uri.getLastPathSegment()));

    }



}
