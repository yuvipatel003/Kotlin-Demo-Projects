package com.yuvrajpatel.mvvm_kotlin.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yuvrajpatel.mvvm_kotlin.model.NicePlaces

class NicePlaceRepository {

    private var dataset : ArrayList<NicePlaces> = ArrayList()
    val TAG = "MVVM-NicePlacesRepository"

    companion object {
        val instance = NicePlaceRepository()
    }

    fun getNicePlaces() : MutableLiveData<List<NicePlaces>> {
        Log.d(TAG, "getNicePlaces()")
        setNicePlace()
        val data : MutableLiveData<List<NicePlaces>> = MutableLiveData()
        data.value = dataset

        return data
    }

    fun setNicePlace(){

        Log.d(TAG, "setNicePlaces()")

        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))
        dataset.add(NicePlaces("India","https://i.redd.it/tpsnoz5bzo501.jpg"))


    }
}