package com.floatingwidgetchathead_demo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class UnlockReceiver extends BroadcastReceiver {

    private static final String TAG = UnlockReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context appContext, Intent intent) {

        if (BuildConfig.DEBUG) {
            Log.i(TAG, "onReceive: " + intent.getAction());
        }

        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_SCREEN_OFF))
        {
            Log.i("Test","off");
        } else if (intent.getAction().equalsIgnoreCase(Intent.ACTION_SCREEN_ON)) {
            Log.i("Test","on");
        }
    }

}