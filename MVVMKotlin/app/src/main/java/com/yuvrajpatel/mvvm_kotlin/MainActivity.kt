package com.yuvrajpatel.mvvm_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuvrajpatel.mvvm_kotlin.adapter.NicePlacesRecyclerViewAdapter
import com.yuvrajpatel.mvvm_kotlin.model.NicePlaces
import com.yuvrajpatel.mvvm_kotlin.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var mNicePlaces: ArrayList<NicePlaces> = ArrayList()
    lateinit var mNicePlacesRecyclerViewAdapter : NicePlacesRecyclerViewAdapter
    lateinit var mMainActivityViewModel : MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mMainActivityViewModel.init()

        mMainActivityViewModel.getNicePlaces().observe(this, object : Observer<List<NicePlaces>> {
            override fun onChanged(t: List<NicePlaces>?) {
                Log.d("MVVM-Recycle MainActivity: " , mMainActivityViewModel.getNicePlaces().value.toString())
                mNicePlacesRecyclerViewAdapter.notifyDataSetChanged()
            }

        })

        initRecyclerView()

        floatingActionButton.setOnClickListener {
            var nicePlace = NicePlaces("Canada","https://i.redd.it/qn7f9oqu7o501.jpg")
            mMainActivityViewModel.addNewNicePlace(nicePlace)
        }
    }

    fun initRecyclerView(){

            mNicePlacesRecyclerViewAdapter =
                NicePlacesRecyclerViewAdapter(mMainActivityViewModel.getNicePlaces().value)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = mNicePlacesRecyclerViewAdapter
    }
}
