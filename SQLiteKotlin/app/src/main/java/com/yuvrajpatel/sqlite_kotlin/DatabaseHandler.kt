package com.yuvrajpatel.sqlite_kotlin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "ExampleDB"
val TABLE_NAME = "User"
val COLUMN_ID = "id"
val COLUMN_NAME = "name"
val COLUMN_AGE = "age"

class DatabaseHandler(var context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null ,1){

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " VARCHAR(256)," + COLUMN_AGE + " INTEGER)"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertUser (user : User) {

        val db = this.writableDatabase

        var contentvalue = ContentValues()
        contentvalue.put(COLUMN_NAME, user.name)
        contentvalue.put(COLUMN_AGE, user.age)

        var result = db.insert(TABLE_NAME,null, contentvalue)

        if(result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

    }

}