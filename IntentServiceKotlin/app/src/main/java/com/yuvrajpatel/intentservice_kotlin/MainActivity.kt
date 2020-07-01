package com.yuvrajpatel.intentservice_kotlin

import android.app.IntentService
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, MyIntentService::class.java)
        intent.putExtra("TYPE",1)
        startService(intent)

        val intent2 = Intent(this, MyIntentService::class.java)
        intent2.putExtra("TYPE",2)
        startService(intent2)
    }
}
