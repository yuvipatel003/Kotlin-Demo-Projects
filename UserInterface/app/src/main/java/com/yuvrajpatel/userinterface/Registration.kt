package com.yuvrajpatel.userinterface

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.Nullable
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_registration.*
import java.lang.Exception

class Registration : AppCompatActivity() {

    val TAG = "Registartion"

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
    lateinit var mSpinnerAge : Spinner

    var mAge = 0
    val ageArray = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

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
        mSpinnerAge = findViewById(R.id.spinnerAge)



        mButtonRegister.setOnClickListener(View.OnClickListener {
            if(checkValidRegistartionDetails()){
                Toast.makeText(this,"Registration Completed", Toast.LENGTH_LONG).show()

                val intent = Intent(this, LayoutExample::class.java )
                startActivity(intent)

            }
        })



        for(i in 10..40){
            ageArray.add(i)
            Log.d(TAG,"i =" + i)
            Log.d(TAG, "Size:" + ageArray.size)
        }

        mSpinnerAge.adapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1,ageArray)

        mSpinnerAge.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                mAge = ageArray.get(p2)
                Toast.makeText(applicationContext, "Age :" + mAge, Toast.LENGTH_SHORT).show()
            }

        }

        retreiveCustomerDetailsFromSharedPreferences()
    }


    fun checkValidRegistartionDetails() : Boolean {

        var strFirstName : String
        var strLastName : String
        var strGender : String = ""
        var strArrayLanguage : ArrayList<String> = ArrayList()

        strFirstName = mEditTextFirstName.text.toString()
        strLastName = mEditTextLastName.text.toString()

        if(mRadioGroupGender.checkedRadioButtonId == -1 ) {
            Toast.makeText(this,"Select Gender", Toast.LENGTH_LONG).show()
            return false
        } else {
            if(mRadioButtonMale.isChecked) strGender = mRadioButtonMale.text.toString()
            if(mRadioButtonFemale.isChecked) strGender = mRadioButtonFemale.text.toString()
            if(mRadioButtonOther.isChecked) strGender = mRadioButtonOther.text.toString()
        }

        if(mCheckBoxLanguageEnglish.isChecked) strArrayLanguage.add(mCheckBoxLanguageEnglish.text.toString())

        if(mCheckBoxLanguageFrench.isChecked) strArrayLanguage.add(mCheckBoxLanguageFrench.text.toString())

        if(mCheckBoxLanguageHindi.isChecked) strArrayLanguage.add(mCheckBoxLanguageHindi.text.toString())


        if(strArrayLanguage.isEmpty()){
            Toast.makeText(this,"Select at least one language", Toast.LENGTH_LONG).show()
            return false
        } else if (strFirstName.isNullOrBlank() || strLastName.isNullOrBlank()){
            Toast.makeText(this,"Please enter customer name", Toast.LENGTH_LONG).show()
            return false
        }

        if(mAge == 0) return false

        if(saveCustomerDetailsInSharedPreferences(strFirstName, strLastName, strGender, strArrayLanguage)) {
            return true
        } else {
            Toast.makeText(this,"Error : customer information not saved", Toast.LENGTH_LONG).show()
        }

        return false
    }

    private fun saveCustomerDetailsInSharedPreferences(strFirstName: String, strLastName: String, strGender: String, strArrayLanguage: ArrayList<String>): Boolean {

        var sharedPreference : SharedPreferences = applicationContext.getSharedPreferences("Customer", 0)
        var editor : SharedPreferences.Editor = sharedPreference.edit()

        try {
            editor.putString("FirstName", strFirstName)
            editor.putString("LastName", strLastName)
            editor.putString("Gender", strGender)
            editor.putInt("Age", mAge)
            editor.putString("FirstLanguage", strArrayLanguage.get(0))

            if(strArrayLanguage.size > 1) {
                editor.putString("SecondLanguage", strArrayLanguage.get(1))
            } else {
                editor.putString("SecondLanguage", null)
            }

            if(strArrayLanguage.size > 2) {
                editor.putString("ThirdLanguage", strArrayLanguage.get(2))
            } else {
                editor.putString("ThirdLanguage", null)
            }
            editor.commit()
        } catch (e : Exception){
            Log.e(TAG,"Error :" + e.toString())
            return false
        }

        return true
    }

    private fun retreiveCustomerDetailsFromSharedPreferences(){
        var sharedPreference : SharedPreferences = applicationContext.getSharedPreferences("Customer", 0)

        var firstname : String = sharedPreference.getString("FirstName", "").toString()
        var lastname : String = sharedPreference.getString("LastName", "").toString()
        var gender : String = sharedPreference.getString("Gender", "").toString()
        var age : Int = sharedPreference.getInt("Age", 0)
        var firstlanguage : String = sharedPreference.getString("FirstLanguage", null).toString()
        var secondlanguage : String = sharedPreference.getString("SecondLanguage", null).toString()
        var thirdlanguage : String = sharedPreference.getString("ThirdLanguage", null).toString()

        var strArrayLanguage : ArrayList<String> = ArrayList()
        strArrayLanguage.add(firstlanguage)
        strArrayLanguage.add(secondlanguage)
        strArrayLanguage.add(thirdlanguage)

        if(mEditTextFirstName != null && mEditTextLastName != null) {
            mEditTextFirstName.setText(firstname)
            mEditTextLastName.setText(lastname)
        }

        Log.e(TAG,"Gender :" + gender)

        if(mRadioButtonMale.text.toString().equals(gender)) {
            mRadioButtonMale.isChecked = true
        } else if(mRadioButtonFemale.text.toString().equals(gender)){
            mRadioButtonFemale.isChecked = true
        } else {
            mRadioButtonOther.isChecked = true
        }
        setLanguagedCheckBoxForExistingCustomer(strArrayLanguage)

        Log.d(TAG,"Shared AGE:" + age)
        mSpinnerAge.setSelection(ageArray.indexOf(age))

    }

    private fun setLanguagedCheckBoxForExistingCustomer(strArrayLanguage: ArrayList<String>) {

        for (language : String in strArrayLanguage){
            if(language.equals(mCheckBoxLanguageEnglish.text.toString())){
                mCheckBoxLanguageEnglish.isChecked = true
            } else if(language.equals(mCheckBoxLanguageFrench.text.toString())){
                mCheckBoxLanguageFrench.isChecked = true
            } else if(language.equals(mCheckBoxLanguageHindi.text.toString())){
                mCheckBoxLanguageHindi.isChecked = true
            } else {
                Log.d(TAG,"Language Not Found")
            }
        }

    }

}

