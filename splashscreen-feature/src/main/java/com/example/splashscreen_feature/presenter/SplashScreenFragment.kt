package com.example.splashscreen_feature.presenter

import android.content.Context
import android.os.Bundle
import com.example.core.base.BaseDaggerFragment
import com.example.core.common.coreComponent
import com.example.core_navigation.navigation.NavigationFlow
import com.example.core_navigation.navigation.ToFlowNavigatable
import com.example.splashscreen_feature.R
import com.example.splashscreen_feature.di.DaggerSplashScreenComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment: BaseDaggerFragment() {

    private var delayJob: Job? = null

    override fun onAttach(context: Context) {
        DaggerSplashScreenComponent.factory().create(coreComponent()).inject(this)
        super.onAttach(context)
    }

    override fun getContentResource(): Int = R.layout.fragment_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delayJob = GlobalScope.launch {
            delay(3000)
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.LoginFlow)
        }
    }

}