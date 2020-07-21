package com.yuvrajpatel.mvvm_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuvrajpatel.mvvm_kotlin.model.NicePlaces
import com.yuvrajpatel.mvvm_kotlin.repository.NicePlaceRepository

class MainActivityViewModel : ViewModel() {

    var mNicePlaces : MutableLiveData<List<NicePlaces>> = MutableLiveData()
    var list = mutableListOf<NicePlaces>()
    var mIsUpdating : MutableLiveData<Boolean> = MutableLiveData()
    val TAG = "MVVM-MainActivityViewModel"

    fun init(){
        Log.d(TAG, "init()")
            Log.d(TAG, "init() add places")
            mNicePlaces = NicePlaceRepository.instance.getNicePlaces()
    }

    fun addNewNicePlace(nicePlace : NicePlaces){

        list.add(nicePlace)
        mNicePlaces.postValue(list)
//        Log.d(TAG, "addNewNicePlace()" + currentNicePlaces.toString())
//        currentNicePlaces.plus(nicePlace)
//
//        Log.d(TAG, "addNewNicePlace() After " + currentNicePlaces.toString())
//        mNicePlaces.postValue(currentNicePlaces)
//        Log.d(TAG, "addNewNicePlace()" + currentNicePlaces.size)
//        Log.d(TAG, "addNewNicePlace()" + currentNicePlaces.get(currentNicePlaces.lastIndex).toString())
    }

    fun getNicePlaces() : LiveData<List<NicePlaces>> {
        Log.d(TAG, "getNicePlaces()")
        return mNicePlaces
    }

}