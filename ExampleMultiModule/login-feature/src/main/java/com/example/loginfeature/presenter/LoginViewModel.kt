package com.example.loginfeature.presenter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.base.BaseViewModel
import com.example.core.common.customSubscribe
import com.example.loginfeature.data.ExampleResponse
import com.example.loginfeature.domain.GetSharePrefIdUseCase
import com.example.loginfeature.domain.Login
import com.example.loginfeature.domain.LoginDbUseCase
import com.example.loginfeature.domain.LoginUseCase

class LoginViewModel(
    private val getUserInfoUseCase: LoginUseCase,
    private val getSharePrefIdUseCase: GetSharePrefIdUseCase,
    private val loginDbUseCase: LoginDbUseCase
): BaseViewModel() {

    private val userInfoMutableLiveData = MutableLiveData<ExampleResponse>()
    val userInfoLiveData: LiveData<ExampleResponse> get() = userInfoMutableLiveData

    private val userIdPrefMutableLiveData = MutableLiveData<String>()
    val userIdPrefLiveData: LiveData<String> get() = userIdPrefMutableLiveData

    private val loginDataFromDbMutableLiveData = MutableLiveData<List<Login>>()
    val loginDataFromDbLiveData: LiveData<List<Login>> get() = loginDataFromDbMutableLiveData

    fun getUserInfo() {
        getUserInfoUseCase.execute().subscribe { value ->
            userInfoMutableLiveData.value = value
        }.collect()
    }

    fun getUserIdSharePref() {
        getSharePrefIdUseCase.execute().subscribe { value ->
            userIdPrefMutableLiveData.value = value
        }.collect()
    }

    fun saveDataToDb(login: Login) {
        loginDbUseCase.saveDataToDb(login)
    }

    fun getDataFromDb() {
        loginDbUseCase.execute().customSubscribe {
            loginDataFromDbMutableLiveData.value = it
        }.collect()
    }

}