package com.yuvrajpatel.service_kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class MyService : Service() {

    val TAG = "MyService"

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        showLog("OnUnbind()")
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        showLog("OnCreate()")
        super.onCreate()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showLog("OnStartCommand()")

        val runnable = Runnable {
            for (i in 0..5) {
                showLog("Service performing " + i.toString())
                Thread.sleep(1000)
            }
            stopSelf()
        }

        val thread = Thread(runnable)
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        showLog("OnDestroy()")
        super.onDestroy()
    }


    fun showLog(message : String){
        Log.d(TAG, message)
    }
}
