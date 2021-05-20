package com.example.splashscreen_feature.view.screen

import androidx.fragment.app.viewModels
import com.example.core.base.BaseFragment
import com.example.splashscreen_feature.R
import com.example.splashscreen_feature.view.viewmodel.SplashScreenViewModel
import com.example.splashscreen_feature.view.viewmodel.navigateToLogin
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : BaseFragment() {

    private var delayJob: Job? = null

    private val viewModel: SplashScreenViewModel by viewModels { factory }

    override fun getContentResource(): Int = R.layout.fragment_splash_screen

    override fun initViews() {
        super.initViews()
        delayJob = GlobalScope.launch {
            delay(3000)
            viewModel.navigateToLogin()
        }
    }


}