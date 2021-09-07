package mirkozaper.from.hr.footballersinfo.BroadcastReceiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import mirkozaper.from.hr.footballersinfo.R

class AlarmReceiver:BroadcastReceiver() {

    val CHANNEL_ID="channelId"
    val CHANNEL_NAME="channelName"
    val NOTIFICATION_ID=0

    override fun onReceive(context: Context?, intent: Intent?) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel=NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor= Color.GREEN
                enableLights(true)
            }
            val manager= context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

        val notification= context?.let {
            NotificationCompat.Builder(it,CHANNEL_ID)
                .setContentTitle("Footballers info")
                .setContentText("Time for training")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()
        }

        val notificationManager= context?.let { NotificationManagerCompat.from(it) }

        notification?.let { notificationManager?.notify(NOTIFICATION_ID, it) }
    }
}