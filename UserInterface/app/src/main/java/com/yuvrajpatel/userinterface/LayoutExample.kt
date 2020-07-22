package com.yuvrajpatel.userinterface

import android.accessibilityservice.GestureDescription
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.nio.file.attribute.AclEntry

class LayoutExample : AppCompatActivity() {

    lateinit var mBtnClickMe : Button
    lateinit var mTxtScroll : TextView
    lateinit var mTxtSteady : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_example)

        mBtnClickMe = findViewById(R.id.btn_ClickMe)

        mBtnClickMe.setOnClickListener(View.OnClickListener {

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Are you sure !")
            alertDialog.setMessage("Do you want to redirect on Registration?")
            alertDialog.setPositiveButton("Yes",{dialogInterface : DialogInterface, i: Int ->
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
                finish()
            })

            alertDialog.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int ->
                dialogInterface.dismiss()
            })

            alertDialog.setNeutralButton("Any",{ dialogInterface: DialogInterface, i: Int -> })
            alertDialog.show()

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
