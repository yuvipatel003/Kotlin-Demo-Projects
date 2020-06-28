package com.yuvrajpatel.userinterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView

class LayoutExample : AppCompatActivity() {

    lateinit var mBtnClickMe : Button
    lateinit var mTxtScroll : TextView
    lateinit var mTxtSteady : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_example)

        mBtnClickMe = findViewById(R.id.btn_ClickMe)

        mBtnClickMe.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        })

        mBtnClickMe.setOnLongClickListener(View.OnLongClickListener {
            mBtnClickMe.text = "Long Clicked"
            true
        })

        mTxtScroll = findViewById(R.id.textView_scroll)
        mTxtScroll.text = "This is long string, which will scroll on screen repeatedly. it is intentionally designed like this "
        mTxtScroll.setSingleLine()
        mTxtScroll.ellipsize = TextUtils.TruncateAt.MARQUEE
        mTxtScroll.marqueeRepeatLimit = -1
        mTxtScroll.isSelected = true


        mTxtSteady = findViewById(R.id.textView_steady)
        mTxtSteady.text = "This is long string, which is steady. it is intentionally designed like this "

    }
}
