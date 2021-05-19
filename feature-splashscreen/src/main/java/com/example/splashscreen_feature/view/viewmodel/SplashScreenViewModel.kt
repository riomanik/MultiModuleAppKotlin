package com.example.splashscreen_feature.view.viewmodel

import com.example.core.base.BaseViewModel
import com.example.splashscreen_feature.navigation.SplashNavigation
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    internal val nav: SplashNavigation
): BaseViewModel() {

}