package org.gitmad.sportsmobile.receiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseBroadcastReceiver;

public class SportsBroadcastReceiver extends ParseBroadcastReceiver {

    private static final String EXTRA_DATA = "com.parse.Data";

    @Override public void onReceive(Context context, Intent intent)
    {
        //Do something interesting here
        Log.d("SportsBroadcastReceiver", "onReceive called.");
        Toast.makeText(context, intent.getStringExtra(EXTRA_DATA), Toast.LENGTH_LONG).show();
    }
}
