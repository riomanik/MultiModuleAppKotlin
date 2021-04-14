package com.example.splashscreen_feature.presenter

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import com.example.core.base.BaseViewModelActivity
import com.example.core.di.InjectUtils
import com.example.loginfeature.presenter.LoginActivity
import com.example.splashscreen_feature.di.SplashScreenFeatureComponent
import com.example.splashscreen_feature.R
import com.example.splashscreen_feature.di.DaggerSplashScreenFeatureComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity: BaseViewModelActivity<SplashScreenViewModel>() {

    lateinit var component: SplashScreenFeatureComponent

    private var delayJob: Job? = null

    override fun initView() {
        setContentView(R.layout.activity_splash_screen)
        instance = this
        component = DaggerSplashScreenFeatureComponent
            .builder()
            .coreComponent(InjectUtils.provideCoreComponent(applicationContext))
            .build()
        component.inject(this)
        val intent = Intent(this, LoginActivity::class.java)
        delayJob = GlobalScope.launch {
            delay(3000)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        delayJob?.cancel()
    }

    override fun initLiveDataObservers() {
        super.initLiveDataObservers()
    }

    companion object {
        lateinit var instance: SplashScreenActivity
            private set
    }

    override fun buildViewModel(): SplashScreenViewModel {
        val factory = SplashScreenViewModelFactory()
        return ViewModelProviders.of(this, factory)[SplashScreenViewModel::class.java]
    }
}