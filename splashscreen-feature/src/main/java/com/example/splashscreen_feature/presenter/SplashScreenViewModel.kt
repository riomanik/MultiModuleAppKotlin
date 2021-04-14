package com.example.splashscreen_feature.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.base.BaseViewModel

class SplashScreenViewModel(
): BaseViewModel() {

    private val userIdPrefMutableLiveData = MutableLiveData<String>()
    val userIdPrefLiveData: LiveData<String> get() = userIdPrefMutableLiveData

}