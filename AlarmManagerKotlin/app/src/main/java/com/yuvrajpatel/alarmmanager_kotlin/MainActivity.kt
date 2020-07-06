package com.yuvrajpatel.alarmmanager_kotlin

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var mContext: Context
    lateinit var mAlarmManager: AlarmManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this
        mAlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        btnCreate.setOnClickListener({
            val milliSeconds = editTextTimer.text.toString().toInt() * 1000
            val intent = Intent(mContext, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(mContext,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity","Create :" + Date().toString())
            mAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + milliSeconds, pendingIntent)
        })

        btnUpdate.setOnClickListener({
            val milliSeconds = editTextTimer.text.toString().toInt() * 1000
            val intent = Intent(mContext, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(mContext,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity","Update :" + Date().toString())
            mAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + milliSeconds, pendingIntent)
        })

        btnCancel.setOnClickListener({
            val intent = Intent(mContext, Receiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(mContext,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("MainActivity","Cancel :" + Date().toString())
            mAlarmManager.cancel(pendingIntent)

        })

    }

    class Receiver : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
           Log.d("MainActivity","Receiver :" + Date().toString())
        }

    }
}
