package com.yuvrajpatel.broadcastreceivers_kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * There are two types of Broadcast receiver
 * 1. Context registered receiver
 * 2. Manifest-declared receiver
 */
class MainActivity : AppCompatActivity() {

    lateinit var mReceiver : BroadcastReceiver
    lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this

        // Context registered receiver
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)

        mReceiver = object : BroadcastReceiver(){
            override fun onReceive(p0: Context?, intent: Intent?) {
                Toast.makeText(mContext, intent?.action, Toast.LENGTH_SHORT).show()
            }

        }

        registerReceiver(mReceiver, filter)


        // Manifest-declared receiver
        btnLaunchBroadcast.setOnClickListener({
            sendBroadcast(Intent(mContext,MyReceiver::class.java))
        })


    }

    override fun onDestroy() {
        unregisterReceiver(mReceiver)
        super.onDestroy()
    }
}
