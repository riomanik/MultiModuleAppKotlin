package com.example.core_navigation.navigation

import androidx.navigation.NavController
import com.example.core_navigation.MainNavGraphDirections

class Navigator {
    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) =
        when (navigationFlow) {
        NavigationFlow.LoginFlow -> navController.navigate(MainNavGraphDirections.actionGlobalLoginFlow())
            else -> navController.navigate(MainNavGraphDirections.actionGlobalLoginFlow())
        }
}