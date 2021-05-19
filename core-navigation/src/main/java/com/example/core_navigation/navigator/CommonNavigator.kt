package com.example.core_navigation.navigator

import com.example.core.base.BaseNavigator
import com.example.core_navigation.NavControllerBinder
import com.example.core_navigation.R
import com.example.core_navigation.navigation.CommonNavigation
import javax.inject.Inject

class CommonNavigator @Inject constructor(
    private val navBinder: NavControllerBinder
) : BaseNavigator(), CommonNavigation {

    override fun navigateToSplash() {
        navBinder.navController?.navigate(R.id.splash_nav_graph, null, transitionIn)
    }

    override fun navigateToLogin() {
        navBinder.navController?.navigate(R.id.login_flow, null, transitionIn)
    }

}