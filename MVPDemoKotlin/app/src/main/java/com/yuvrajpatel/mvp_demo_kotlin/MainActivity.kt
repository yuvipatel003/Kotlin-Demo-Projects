package com.yuvrajpatel.mvp_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), MainActivityPresenter.View{

    lateinit var editTextName : EditText
    lateinit var editTextEmail : EditText
    lateinit var textViewDisplay : TextView
    lateinit var presentor : MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextName = findViewById(R.id.editTextName)
        textViewDisplay = findViewById(R.id.textViewDisplay)
        presentor = MainActivityPresenter(this)

        editTextEmail.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presentor.updateEmail(s.toString())
            }

        })

        editTextName.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presentor.updateFullName(s.toString())
            }

        })

    }


    override fun updateUserInfoTextView(info: String) {
        textViewDisplay.setText(info)
    }

}
