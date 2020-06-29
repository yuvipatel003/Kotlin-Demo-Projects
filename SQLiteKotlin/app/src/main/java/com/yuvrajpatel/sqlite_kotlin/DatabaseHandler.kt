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

        db.close()
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME

        val result = db.rawQuery(query, null)

        if(result.moveToFirst()) {

            do {
                var user = User()

                user.id = result.getString(result.getColumnIndex(COLUMN_ID)).toString().toInt()
                user.name = result.getString(result.getColumnIndex(COLUMN_NAME)).toString()
                user.age = result.getString(result.getColumnIndex(COLUMN_AGE)).toString().toInt()

                list.add(user)

            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun deleteAllData() {
        val db = this.writableDatabase

        db.delete(TABLE_NAME,null,null)
        db.close()
    }

    fun getId(name: String) : Int {
        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME

        val result = db.rawQuery(query, null)

        if(result.moveToFirst()) {

            do {
                var user = User()

                user.id = result.getString(result.getColumnIndex(COLUMN_ID)).toString().toInt()
                user.name = result.getString(result.getColumnIndex(COLUMN_NAME)).toString()
                user.age = result.getString(result.getColumnIndex(COLUMN_AGE)).toString().toInt()

                if(user.name == name){
                    return user.id
                }

            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return -1
    }

    fun updateAge (id : Int, age : Int) {
        val db = this.writableDatabase

        val query = "Select * from " + TABLE_NAME

        val result = db.rawQuery(query, null)

        var cv = ContentValues()
        cv.put(COLUMN_AGE, age)
        db.update(TABLE_NAME, cv,COLUMN_ID + "=?", arrayOf(id.toString()))
        db.close()
    }

}