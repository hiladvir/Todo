package com.example.mytest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("tal1", "talllll");
        Toast.makeText(context, "ALARM", Toast.LENGTH_LONG).show();

    }
}
