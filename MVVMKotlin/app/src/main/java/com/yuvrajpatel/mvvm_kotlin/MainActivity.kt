package com.yuvrajpatel.mvvm_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuvrajpatel.mvvm_kotlin.adapter.NicePlacesRecyclerViewAdapter
import com.yuvrajpatel.mvvm_kotlin.model.NicePlaces
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mNicePlaces: ArrayList<NicePlaces> = ArrayList()
    lateinit var nicePlacesRecyclerViewAdapter : NicePlacesRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var place = NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg")
        Log.d("Recycle MainActivity: " , place.toString())
        mNicePlaces.add(place)
        initRecyclerView()
    }

    fun initRecyclerView(){

        nicePlacesRecyclerViewAdapter = NicePlacesRecyclerViewAdapter(mNicePlaces)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = nicePlacesRecyclerViewAdapter
    }
}
