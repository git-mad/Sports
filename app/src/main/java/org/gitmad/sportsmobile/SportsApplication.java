package org.gitmad.sportsmobile;

import android.app.Application;
import android.content.Context;

/**
 * Created by Alex on 10/19/2014.
 */
public class SportsApplication extends Application {
    private static Context context;

    public void onCreate(){
        super.onCreate();
        SportsApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return SportsApplication.context;
    }
}
