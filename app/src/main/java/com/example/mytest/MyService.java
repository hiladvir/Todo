package com.example.mytest;

import static java.security.AccessController.getContext;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import java.security.Provider;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        showNotification();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channelId")
                .setContentTitle("תזכורת")
                .setSmallIcon(R.drawable.itamara)
                .setContentText("התתראה בזמן שמבוקש")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManager.notify(1, builder.build());
      //  private static final int REQUEST_NOTIFICATION_PERMISSION = 1;
        //if(ContextCompat.checkSelfPermission(this,Manifest.permission.VIBRATE)!= PackageManager
           //     .PERMISSION_GRANTED)
            //ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.POST_NOTIFICATIONS}
                   // , REQUEST_NOTIFICATION_PERMISSION);{

        }
}



