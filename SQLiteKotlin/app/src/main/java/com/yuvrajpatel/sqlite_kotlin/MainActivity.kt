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
        var databaseHandler = DatabaseHandler(context)

        btnSave.setOnClickListener({
            if(editTextName.text.toString().length > 0 && editTextAge.text.toString().length > 0) {
                var user = User(editTextName.text.toString(), editTextAge.text.toString().toInt())
                databaseHandler?.insertUser(user)

            } else {
                Toast.makeText(context, "Please fill all information", Toast.LENGTH_SHORT).show()
            }
        })

        btnRead.setOnClickListener({
           var data = databaseHandler.readData()
            textViewResult.text = ""

            for(i in 0..(data.size - 1)){
                textViewResult.append(data.get(i).id.toString() + " " +
                        data.get(i).name.toString() + " " +
                        data.get(i).age.toString() + "\n")
            }
        })

        btnDelete.setOnClickListener({
           databaseHandler.deleteAllData()
            btnRead.performClick()
        })

        btnUpdate.setOnClickListener({
           var id = databaseHandler.getId(editTextName.text.toString())

            if(id != -1) {
                databaseHandler.updateAge(id, editTextAge.text.toString().toInt())
            } else {
                Toast.makeText(context, "Record not found", Toast.LENGTH_SHORT).show()
            }
            btnRead.performClick()

        })
    }
}
