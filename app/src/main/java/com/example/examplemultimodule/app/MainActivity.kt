package com.example.examplemultimodule.app

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.core_navigation.navigation.NavigationFlow
import com.example.core_navigation.navigation.Navigator
import com.example.core_navigation.navigation.ToFlowNavigatable
import com.example.examplemultimodule.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity: DaggerAppCompatActivity(), ToFlowNavigatable{

    private val navigator: Navigator = Navigator()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        navigator.navController = navController
//        navController = findNavController(R.id.nav_host_fragment)
//        NavigationUI.setupWithNavController( navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (!NavigationUI.navigateUp(navController, null)) {
            onBackPressed()
        }

        return true
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navigator.navigateToFlow(flow)
    }

}