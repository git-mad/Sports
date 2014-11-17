package org.gitmad.sportsmobile;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import org.gitmad.sportsshared.ClientPaths;
import org.gitmad.sportsshared.DataMapKeys;

public class MessageReceiverService extends WearableListenerService {
    private static final String TAG = "SensorDashboard/MessageReceiverService";

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        super.onDataChanged(dataEvents);

        for (DataEvent dataEvent : dataEvents) {
            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                DataItem dataItem = dataEvent.getDataItem();
                Uri uri = dataItem.getUri();
                String path = uri.getPath();

                if (path.startsWith("/filter")) {
                    DataMap dataMap = DataMapItem.fromDataItem(dataItem).getDataMap();
                    int filterById = dataMap.getInt(DataMapKeys.FILTER);
                    final Intent intent = new Intent(SensorService.ACTION_FILTER_BY_ID);
                    intent.putExtra(SensorService.EXTRA_FILTER_BY_ID, filterById);
                    LocalBroadcastManager.getInstance(this).sendBroadcastSync(intent);
                }
            }
        }
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d(TAG, "Received message: " + messageEvent.getPath());

        if (ClientPaths.START_MEASUREMENT.equals(messageEvent.getPath())) {
            startService(new Intent(this, SensorService.class));
        } else if (ClientPaths.STOP_MEASUREMENT.equals(messageEvent.getPath())) {
            stopService(new Intent(this, SensorService.class));
        }
    }
}
