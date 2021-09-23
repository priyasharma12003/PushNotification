package com.example.projectm2;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        getFirebasemsg(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }



    public void getFirebasemsg(String title,String msg){

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"myFirebaseChannel")
                .setSmallIcon(R.drawable.ic_baseline_notifications_none_24)
                .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);

        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
        managerCompat.notify(101,builder.build());
    }
}
