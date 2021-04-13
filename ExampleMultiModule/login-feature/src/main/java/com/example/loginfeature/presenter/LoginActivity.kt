package com.example.loginfeature.presenter

import androidx.lifecycle.ViewModelProviders
import com.example.core.base.BaseViewModelActivity
import com.example.core.common.SafeObserver
import com.example.core.di.InjectUtils
import com.example.loginfeature.R
import com.example.loginfeature.di.DaggerLoginFeatureComponent
import com.example.loginfeature.di.LoginFeatureComponent
import com.example.loginfeature.domain.Login
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseViewModelActivity<LoginViewModel>() {

    lateinit var component: LoginFeatureComponent

    override fun initView() {
        setContentView(R.layout.activity_login)
        instance = this
        component = DaggerLoginFeatureComponent
            .builder()
            .coreComponent(InjectUtils.provideCoreComponent(applicationContext))
            .build()
        component.inject(this)
        btnGetUserInfo.setOnClickListener{
            viewModel.getUserInfo()
        }
        btnGetUserId.setOnClickListener {
            viewModel.getUserIdSharePref()
        }
        btnSaveToDb.setOnClickListener {
            viewModel.saveDataToDb(Login(1, "Junifer"))
        }
        btnGetFromDb.setOnClickListener {
            viewModel.getDataFromDb()
        }
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
        viewModel.userInfoLiveData.observe(this, SafeObserver{
            tvUserInfo.text = it.title
        })
        viewModel.userIdPrefLiveData.observe(this, SafeObserver{
            tvUserIdPref.text = it
        })
        viewModel.loginDataFromDbLiveData.observe(this, SafeObserver{
            tvDataFromDb.text = it.first().username
        })
    }

    companion object {
        lateinit var instance: LoginActivity
            private set
    }

    override fun buildViewModel(): LoginViewModel {
        val factory = LoginViewModelFactory()
        return ViewModelProviders.of(this, factory)[LoginViewModel::class.java]
    }
}