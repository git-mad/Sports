package org.gitmad.sportsmobile.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.parse.ParseBroadcastReceiver;

import org.gitmad.sportsmobile.R;
import org.json.JSONException;
import org.json.JSONObject;

public class SportsBroadcastReceiver extends ParseBroadcastReceiver {

    private static final String EXTRA_DATA = "com.parse.Data";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SportsBroadcastReceiver", "onReceive called.");

        //Here is where we parse the json payload of the notification.
        //This is Parse's default message format:
        /*
        {
              "alert": "Tune in for the World Series, tonight at 8pm EDT",
              "badge": "Increment",
              "sound": "chime",
              "title": "Baseball News"
        }
        Parse stores default message data into two extras, com.parse.Data and com.parse.Channel. (CASE SENSITIVE)
        */

        Log.d("SportsBroadcastReceiver", "Total extras: " + intent.getExtras().keySet().size());

        for (String key : intent.getExtras().keySet()) {
            Log.d("Extras: ", key + " :" + intent.getStringExtra(EXTRA_DATA));
        }

        String alert = context.getString(R.string.notification_alert_default);

        try {
            JSONObject json = new JSONObject(intent.getStringExtra(EXTRA_DATA));
            if (!json.isNull("alert"))
                alert = json.getString("alert");
        } catch (JSONException e) {
            Log.d("SportsBroadcastReceiver", "Unable to parse json response");
        }

        final Notification noti = new NotificationCompat.Builder(context)
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(alert)
                .setSmallIcon(R.drawable.ic_stat_alert)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.drawable.ic_launcher))
                .build();

        final NotificationManager manager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(NOTIFICATION_ID, noti);
    }
}
