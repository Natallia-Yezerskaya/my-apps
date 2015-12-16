package com.test.lesson15.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.test.lesson15.MainActivity;
import com.test.lesson15.R;
import com.test.lesson15.services.MyService;

/**
 * Created by USER on 16.12.2015.
 */
public class ExampleAppWidgetProvider  extends AppWidgetProvider{

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
           // Intent intent = new Intent(context, MyService.class);
           // intent.putExtra(MyService.ACTION,MyService.ACTION_BT_ON_OFF);
            //PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

            Intent intent1 = new Intent(context, MyService.class);
            intent1.putExtra(MyService.ACTION,MyService.ACTION_WF);
            PendingIntent pendingIntent1 = PendingIntent.getService(context, 0, intent1, 0);

           // PendingIntent pendingIntent2 = PendingIntent.getService(context, 0, intent, 0);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.second_layout);
            //views.setOnClickPendingIntent(R.id.textView2, pendingIntent);
            //views.setOnClickPendingIntent(R.id.button,pendingIntent);
            views.setOnClickPendingIntent(R.id.button1,pendingIntent1);
           // views.setOnClickPendingIntent(R.id.button2,pendingIntent2);




            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}


