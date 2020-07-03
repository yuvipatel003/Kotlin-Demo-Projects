package com.yuvrajpatel.datetimepicker_kotlin

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    var dateFormatter = SimpleDateFormat("dd MMM YYYY", Locale.US)
    var timeFormatter = SimpleDateFormat("hh:mm a", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->

                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                var date = dateFormatter.format(selectedDate.time)

                Toast.makeText(this,"Selected Date : " + date.toString(), Toast.LENGTH_SHORT).show()

//                Toast.makeText(this,"Selected \n Year: " + year +
//                                "\n Month: " + month +
//                                "\n Day: " + dayOfMonth, Toast.LENGTH_SHORT).show()


            },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))

            datePicker.show()
        }


        btnTimePicker.setOnClickListener {
            val now = Calendar.getInstance()
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minute ->

                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR, hourOfDay)
                selectedTime.set(Calendar.MINUTE, minute)

                Toast.makeText(this,"Selected Time : " + timeFormatter.format(selectedTime.time), Toast.LENGTH_SHORT).show()

            },
                now.get(Calendar.HOUR),now.get(Calendar.MINUTE),false)

            timePicker.show()
        }
    }
}
