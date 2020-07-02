package com.yuvrajpatel.popupmenu_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPopupMenu.setOnClickListener {

            val popupMenu = PopupMenu(this, btnPopupMenu)

            popupMenu.inflate(R.menu.main)
            popupMenu.setOnMenuItemClickListener {
                Toast.makeText(this,"Selected :" + it?.title, Toast.LENGTH_SHORT).show()
                true
            }

            popupMenu.show()
        }


        btnPopupWindow.setOnClickListener {

            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup_window, null)
            window.contentView = view
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setOnClickListener {
                window.dismiss()
            }
            window.showAsDropDown(btnPopupWindow)
        }
    }
}
