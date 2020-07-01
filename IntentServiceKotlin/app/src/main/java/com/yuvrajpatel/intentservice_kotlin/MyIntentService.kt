package com.yuvrajpatel.intentservice_kotlin

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService"){

    override fun onHandleIntent(intent: Intent?) {
        for(i in 0 .. 5){
            Log.d("IntentService" ,"Task "+intent?.getIntExtra("TYPE",0).toString()+ " Performing .. " + i)
            Thread.sleep(1000)
        }
    }

}