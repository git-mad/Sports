package org.gitmad.sportsmobile;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParsePush;
import com.parse.SaveCallback;

public class SportsApplication extends Application {

    public void onCreate(){
        super.onCreate();
        Parse.initialize(this, "QtW6kuvTMHtA2YH9IqJAglvcyY7SBuW6u7lMXV1E", "mIqB1YV9ODDrxz12AogeKQaKq1Il7EtBOLwINYSo");
        // Also in this method, specify a default Activity to handle push notifications
        ParsePush.subscribeInBackground("", new SaveCallback() {
            @Override
            public void done(ParseException e) {
            }
        });
    }
}
