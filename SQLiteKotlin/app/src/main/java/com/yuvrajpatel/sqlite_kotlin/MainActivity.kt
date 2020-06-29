package com.yuvrajpatel.sqlite_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        btnSave.setOnClickListener({
            if(editTextName.text.toString().length > 0 && editTextAge.text.toString().length > 0) {
                var user = User(editTextName.text.toString(), editTextAge.text.toString().toInt())
                var databaseHandler = DatabaseHandler(context)
                databaseHandler?.insertUser(user)

            } else {
                Toast.makeText(context, "Please fill all information", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
