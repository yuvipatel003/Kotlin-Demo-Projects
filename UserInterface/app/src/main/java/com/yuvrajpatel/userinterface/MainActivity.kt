package com.yuvrajpatel.userinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var mEditTextFirstName : EditText
    lateinit var mEditTextLastName : EditText
    lateinit var mRadioGroupGender: RadioGroup
    lateinit var mRadioButtonMale: RadioButton
    lateinit var mRadioButtonFemale: RadioButton
    lateinit var mRadioButtonOther: RadioButton
    lateinit var mCheckBoxLanguageEnglish : CheckBox
    lateinit var mCheckBoxLanguageFrench : CheckBox
    lateinit var mCheckBoxLanguageHindi : CheckBox
    lateinit var mButtonRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mEditTextFirstName = findViewById(R.id.editTextFirstname)
        mEditTextLastName = findViewById(R.id.editTextLastname)
        mRadioGroupGender = findViewById(R.id.radioGroupGender)
        mRadioButtonMale = findViewById(R.id.radioButtonGenderMale)
        mRadioButtonFemale = findViewById(R.id.radioButtonGenderFemale)
        mRadioButtonOther = findViewById(R.id.radioButtonGenderOther)
        mCheckBoxLanguageEnglish = findViewById(R.id.checkBoxLanguageEnglish)
        mCheckBoxLanguageFrench = findViewById(R.id.checkBoxLanguageFrench)
        mCheckBoxLanguageHindi = findViewById(R.id.checkBoxLanguageHindi)
        mButtonRegister = findViewById(R.id.buttonRegister)

        mButtonRegister.setOnClickListener(View.OnClickListener {
            if(checkValidRegistartionDetails()){
                Toast.makeText(this,"Registration Completed", Toast.LENGTH_LONG).show()
            }
        })




    }

    fun checkValidRegistartionDetails() : Boolean {

        var strFirstName : String
        var strLastName : String
        var strGender : String
        var strArrayLanguage : ArrayList<String> = ArrayList()

        strFirstName = mEditTextFirstName.text.toString()
        strLastName = mEditTextLastName.text.toString()

        if(mRadioGroupGender.checkedRadioButtonId == -1 ) {
            Toast.makeText(this,"Select Gender", Toast.LENGTH_LONG).show()
            return false
        } else {
            strGender = mRadioGroupGender.checkedRadioButtonId.toString()
        }

        if(mCheckBoxLanguageEnglish.isChecked) strArrayLanguage.add(mCheckBoxLanguageEnglish.text.toString())

        if(mCheckBoxLanguageFrench.isChecked) strArrayLanguage.add(mCheckBoxLanguageFrench.text.toString())

        if(mCheckBoxLanguageHindi.isChecked) strArrayLanguage.add(mCheckBoxLanguageHindi.text.toString())


        if(strArrayLanguage.isEmpty() || strFirstName.isNullOrBlank() || strLastName.isNullOrBlank()) {
            Toast.makeText(this,"Select at least one language", Toast.LENGTH_LONG).show()
            return false
        }

        return true
    }

}
