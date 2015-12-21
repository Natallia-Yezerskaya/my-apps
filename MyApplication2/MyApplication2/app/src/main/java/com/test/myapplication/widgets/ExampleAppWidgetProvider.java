package com.test.myapplication.widgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.test.myapplication.R;
import com.test.myapplication.activities.MainActivity;
import com.test.myapplication.services.WidgetService;

public class ExampleAppWidgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, WidgetService.class);
            intent.putExtra(WidgetService.ACTION, WidgetService.ACTION_BT_ON_OFF);
            PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);


            // Create an Intent to launch ExampleActivity
            Intent intent1 = new Intent(context, WidgetService.class);
            intent1.putExtra(WidgetService.ACTION, WidgetService.ACTION_BT_ON_OFF);
            PendingIntent pendingIntent2 = PendingIntent.getService(context, 0, intent1, 0);


            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(),
                    R.layout.view_mywidget);
            views.setOnClickPendingIntent(R.id.textView2, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
