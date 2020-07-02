package com.yuvrajpatel.contentprovider_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mContext : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this
        readContacts()
    }

    fun readContacts (){

        val contacts : MutableList<String> = ArrayList()

        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)

        if(cursor != null && cursor.moveToFirst()){
            do{
                val contact = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                Log.d("readContacts", contact)
                contacts.add(contact)

            } while(cursor.moveToNext())
        }

        autoCompleteContact.setAdapter(ArrayAdapter(mContext,android.R.layout.simple_list_item_1,contacts))
        autoCompleteContact.threshold = 1

        autoCompleteContact.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(adpater: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                Toast.makeText(mContext,"Selected : " + adpater?.getItemAtPosition(position), Toast.LENGTH_SHORT).show()
            }
        }

    }
}
