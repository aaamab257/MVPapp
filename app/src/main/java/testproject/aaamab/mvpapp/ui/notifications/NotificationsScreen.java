package testproject.aaamab.mvpapp.ui.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBindingUtil;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import testproject.aaamab.mvpapp.R;
import testproject.aaamab.mvpapp.databinding.ActivityNotificationsScreenBinding;
import testproject.aaamab.mvpapp.services.ForgroundService;

public class NotificationsScreen extends AppCompatActivity {
    MyHandler handler ;
    ActivityNotificationsScreenBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this , R.layout.activity_notifications_screen);
        handler = new MyHandler(this);
        binding.setHandler(handler);
    }

    public class MyHandler{
        Context context ;

        public MyHandler(Context context) {
            this.context = context;
        }
        public void showNotification(View v){
            //showMyNotification();
            startService(new Intent(NotificationsScreen.this , ForgroundService.class));
        }
        public void endService(View v){
            stopService(new Intent(NotificationsScreen.this , ForgroundService.class));
        }
    }

    private void showMyNotification() {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int notificationId = 1;
        String channelId = "channel-01";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    channelId, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }


        Uri alarmSound = RingtoneManager
                .getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        long pattern[] = {0, 800, 200, 300, 400};

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.person_24)
                .setContentTitle("Welcome")
                .setContentText("Hello Ahmed Ashraf")
                .setSound(alarmSound)
                .setAutoCancel(true)
                .setVibrate(pattern);



        notificationManager.notify(notificationId, mBuilder.build());

    }
}