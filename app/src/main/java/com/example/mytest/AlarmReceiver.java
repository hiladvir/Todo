package com.example.mytest;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Date;
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       Toast.makeText(context, "תזכורת!!!", Toast.LENGTH_LONG).show();
       Intent serviceIntent = new Intent(context,MyService.class);
       context.startService(serviceIntent);
    }

}
