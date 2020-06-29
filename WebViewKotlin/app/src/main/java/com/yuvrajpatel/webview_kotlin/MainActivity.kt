package com.yuvrajpatel.webview_kotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webViewMain.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener({
            webViewMain.loadUrl("https://" + editTextUrl.text.toString())
        })

        btnBack.setOnClickListener({
            if(webViewMain.canGoBack()){
                webViewMain.goBack()
            } else {
                Toast.makeText(applicationContext, "No History Available", Toast.LENGTH_SHORT).show()
            }
        })

        btnForward.setOnClickListener({
            if(webViewMain.canGoForward()){
                webViewMain.goForward()
            } else {
                Toast.makeText(applicationContext, "No History Available", Toast.LENGTH_SHORT).show()
            }
        })

    }


    class MyWebViewClient : WebViewClient() {

    //    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

//        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//            view?.loadUrl(url.toString())
//            return true
//        }

    }
}
