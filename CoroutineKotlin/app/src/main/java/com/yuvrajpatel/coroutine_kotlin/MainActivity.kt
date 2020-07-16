package com.yuvrajpatel.coroutine_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val RESULT_ONE = "Result # 1"
    val RESULT_TWO = "Result # 2"
    val TAG = "TAG_COROUTINE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnClickMe.setOnClickListener {

            CoroutineScope(IO).launch {
                fakeApiRequests()
            }
        }
    }

    private fun updateText(newString : String) {
        var textViewString = textView.text.toString() + "\n$newString"
        textView.setText(textViewString)
    }

    private suspend fun updateUITextOnMainThread(newString: String){
        withContext(Main){
            updateText(newString)
        }
    }
    private suspend fun fakeApiRequests(){
        val resultOne = getResultFromApiOne()
        updateUITextOnMainThread(resultOne)

        val resultTwo = getResultFromApiTwo()
        updateUITextOnMainThread(resultTwo)
    }

    private suspend fun getResultFromApiOne() : String{
        logThread("getResultFromApiOne()")
        delay(1000)
        return RESULT_ONE
    }

    private suspend fun getResultFromApiTwo() : String{
        logThread("getResultFromApiTwo()")
        delay(2000)
        return RESULT_TWO
    }

    private fun logThread(functionName: String) {
        println("$TAG Function :" + functionName + " Thread :" + Thread.currentThread())
    }
}
