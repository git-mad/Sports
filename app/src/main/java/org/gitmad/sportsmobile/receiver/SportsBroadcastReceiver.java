package org.gitmad.sportsmobile.receiver;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParseBroadcastReceiver;

/**
 * Created by Andre on 11/2/2014.
 */
public class SportsBroadcastReceiver extends ParseBroadcastReceiver {

    private static final String ACTION="org.gitmad.sportsmobile.receiver.SportsPushAction";

    @Override public void onReceive(Context context, Intent intent)
    {
        //Do something interesting here
        Log.d("SportsBroadcastReceiver", "onReceive called.");
        super.onReceive(context, intent);
    }
}
