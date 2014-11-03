package org.gitmad.sportsmobile.receiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParseBroadcastReceiver;

public class SportsBroadcastReceiver extends ParseBroadcastReceiver {

    private static final String ACTION ="org.gitmad.sportsmobile.receiver.SportsPushAction";

    @Override public void onReceive(Context context, Intent intent)
    {
        //Do something interesting here
        Log.d("SportsBroadcastReceiver", "onReceive called.");
        super.onReceive(context, intent);
    }
}
