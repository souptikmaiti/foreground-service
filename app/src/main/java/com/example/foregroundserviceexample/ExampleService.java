package com.example.foregroundserviceexample;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.foregroundserviceexample.AppNotificationChannel.CHANNEL_ID;

public class ExampleService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent actionIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,actionIntent,0);

        String str = intent.getStringExtra("EXTRA_TEXT");
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Foreground Service Notification")
                .setContentText(str)
                .setSmallIcon(R.drawable.ic_insert_emoticon)
                .setContentIntent(pendingIntent)
                .build();

        //do heavy work on different background thread
        startForeground(1,notification);
        //stopSelf();  you must stop the foreground service from here or from activity.. otherwise it keeps on running forever.

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
