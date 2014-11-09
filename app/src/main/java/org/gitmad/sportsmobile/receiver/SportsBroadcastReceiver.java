package org.gitmad.sportsmobile.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParseBroadcastReceiver;

import org.gitmad.sportsmobile.R;
import org.json.JSONException;
import org.json.JSONObject;

public class SportsBroadcastReceiver extends ParseBroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
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

        Log.d("SportsBroadcastReceiver Total extras: ", "" + intent.getExtras().keySet().size());

        for(String key : intent.getExtras().keySet())
        {
            Log.d("Extras: ", key + " :" + intent.getStringExtra("com.parse.Data"));
        }

        String alert = "My Sports Notification";

        try
        {
            JSONObject json = new JSONObject(intent.getStringExtra("com.parse.Data"));
            if(json.getString("alert") != null)
            {
                alert = json.getString("alert");
            }
        }
        catch (JSONException e)
        {
            Log.d("SportsBroadcastReceiver", "Unable to parse json response");
        }

        Notification noti = new Notification.Builder(context)
                .setContentTitle("GIT MAD SPORTS")
                .setContentText(alert)
                .setSmallIcon(R.drawable.bears)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_launcher))
                .build();

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(1,noti);
    }
}
