package com.yuvrajpatel.menu_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)

        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        menu?.getItem(2)?.setEnabled(false)
        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var selectedOption = ""

        when (item?.itemId){
            R.id.menu_aboutus -> selectedOption = "About Us"
            R.id.menu_contactus -> selectedOption = "Contact Us"
            R.id.menu_help -> selectedOption = "Help"
            R.id.menu_item1 -> selectedOption = "Item 1"
            R.id.menu_item2 -> selectedOption = "Item 2"
        }

        Toast.makeText(applicationContext, "Selected : " + selectedOption, Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }
}
