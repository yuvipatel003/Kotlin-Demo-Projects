package com.yuvrajpatel.coroutine_jobs_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private val PROGERSSBAR_MAX = 100
    private val PROGERSSBAR_START = 0
    private val JOB_TIME = 5000
    private lateinit var job : CompletableJob


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStartJob.setOnClickListener {
            if(! :: job.isInitialized){
                initJob()
            }
            progressBar.startJobOrCancel(job)
        }
    }


    fun ProgressBar.startJobOrCancel(job : Job){

        if(this.progress > 0){
            println("${job} is alerady active. Cancelling...")
            resetJob()
        } else {
            btnStartJob.setText("Cancel Job # 1")
            CoroutineScope(IO + job).launch {
            println("${this} coroutine is activated with Job : ${job}")
                for (i in PROGERSSBAR_START .. PROGERSSBAR_MAX){
                    delay((JOB_TIME/PROGERSSBAR_MAX).toLong())
                    this@startJobOrCancel.progress = i
                }

                updateTextView("Job is complete")
            }
        }

    }

    private fun updateTextView(text : String){
        GlobalScope.launch(Main) {
            textViewDisplay.setText(text)
        }
    }
    private fun resetJob() {
        if(job.isActive || job.isCompleted){
            job.cancel(CancellationException("Resetting job"))
            updateTextView("Job reset")
        }
        initJob()
    }

    private fun initJob(){

        btnStartJob.setText("Start Job # 1")
        textViewDisplay.setText("")
        job = Job()
        job.invokeOnCompletion {
            it?.message.let {
                var msg = it
                if(msg.isNullOrBlank()){
                    msg = "Unknown cancellation"
                }
                println("${job} was cancellaed. Reason : $msg")
                showToast(msg)
            }
        }

        progressBar.max = PROGERSSBAR_MAX
        progressBar.progress = PROGERSSBAR_START

    }

    fun showToast(msg : String){
        GlobalScope.launch(Main) {
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
