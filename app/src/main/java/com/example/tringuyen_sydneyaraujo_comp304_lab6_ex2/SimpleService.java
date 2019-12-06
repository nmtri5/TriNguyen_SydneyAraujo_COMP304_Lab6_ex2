package com.example.tringuyen_sydneyaraujo_comp304_lab6_ex2;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class SimpleService extends Service {
    //replace with your package name
    public static final String INFO_INTENT = "com.example.tringuyen_sydneyaraujo_com304_lab6_ex2.INFO_UPDATE";

    public SimpleService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(INFO_INTENT);
        broadcastIntent.putExtra(INFO_INTENT, "Hello there! A simple service is sending this message to you !");
        this.sendBroadcast(broadcastIntent);
//
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed",
                Toast.LENGTH_LONG).show();
    }
}
