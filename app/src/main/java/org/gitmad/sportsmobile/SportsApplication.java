package org.gitmad.sportsmobile;

import android.app.Application;

import com.parse.Parse;
import com.parse.PushService;

import org.gitmad.sportsmobile.activity.MainActivity;

public class SportsApplication extends Application {

    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "QtW6kuvTMHtA2YH9IqJAglvcyY7SBuW6u7lMXV1E", "mIqB1YV9ODDrxz12AogeKQaKq1Il7EtBOLwINYSo");
        // Also in this method, specify a default Activity to handle push notifications
        PushService.setDefaultPushCallback(this, MainActivity.class);
    }
}
