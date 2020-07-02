package com.yuvrajpatel.notification_kotlin

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder : Notification.Builder
    private var channelId = "com.yuvrajpatel.notification_kotlin"
    private var channelDescription = "Notification-Kotlin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        btnSendNotification.setOnClickListener {

            val intent = Intent(this,LauncherActivity ::class.java)
            val pendingIntent = PendingIntent.getActivity(this,0, intent,PendingIntent.FLAG_UPDATE_CURRENT)

            val contentView = RemoteViews(packageName,R.layout.notification_layout)
            contentView.setTextViewText(R.id.textViewNotificationTitle,"Custom Layout")
            contentView.setTextViewText(R.id.textViewNotificationContent,"Custom Layout Content")

            notificationChannel = NotificationChannel(channelId,channelDescription, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(this, channelId)
//                .setContentTitle("Kotlin")
//                .setContentText("Notification Test")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContent(contentView)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher_round))
                .setContentIntent(pendingIntent)

            notificationManager.notify(1234, builder.build())

        }
    }
}
