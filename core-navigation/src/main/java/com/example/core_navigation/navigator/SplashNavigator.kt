package com.example.core_navigation.navigator

import com.example.core.base.BaseNavigator
import com.example.core_navigation.NavControllerBinder
import com.example.core_navigation.R
import com.example.splashscreen_feature.navigation.SplashNavigation
import javax.inject.Inject

class SplashNavigator @Inject constructor(
    private val navBinder: NavControllerBinder
) : BaseNavigator(), SplashNavigation {

    override fun navigateToLogin() {
        navBinder.navController?.navigate(R.id.login_flow, null, transitionIn)
    }

    override fun navigateToHome() {
//        navBinder.navController?.navigate(R.id)
    }

}