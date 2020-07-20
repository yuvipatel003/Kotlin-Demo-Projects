package com.yuvrajpatel.mvvm_kotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yuvrajpatel.mvvm_kotlin.model.NicePlaces

class MainActivityViewModel : ViewModel {

    lateinit var mNicePlaces : MutableLiveData<List<NicePlaces>>

}