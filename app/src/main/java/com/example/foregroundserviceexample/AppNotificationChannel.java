package com.example.foregroundserviceexample;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class AppNotificationChannel extends Application {
    public static final String CHANNEL_ID = "Channel_1";
    @Override
    public void onCreate() {
        super.onCreate();
        getNotificationChannel();
    }

    private  void getNotificationChannel(){
        NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID,"Channel 1" ,NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(serviceChannel);
    }
}
