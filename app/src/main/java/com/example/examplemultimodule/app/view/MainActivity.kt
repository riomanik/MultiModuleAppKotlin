package com.example.examplemultimodule.app.view

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.core_navigation.NavControllerBinder
import com.example.examplemultimodule.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity: DaggerAppCompatActivity() {

    private lateinit var navController: NavController

    @Inject
    lateinit var binder: NavControllerBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (!NavigationUI.navigateUp(navController, null)) {
            onBackPressed()
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        binder.bind(navController)
    }

    override fun onPause() {
        super.onPause()
        binder.unbind()
    }

}