package com.example.splashscreen_feature.presenter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core_navigation.navigation.NavigationFlow
import com.example.core_navigation.navigation.ToFlowNavigatable
import com.example.splashscreen_feature.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashScreenFragment: Fragment(), HasAndroidInjector {

    @Inject
    protected lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private var delayJob: Job? = null

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delayJob = GlobalScope.launch {
            delay(3000)
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.LoginFlow)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}