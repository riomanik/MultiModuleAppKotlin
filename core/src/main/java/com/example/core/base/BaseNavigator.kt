package com.example.core.base

import androidx.navigation.navOptions
import com.example.core.R


abstract class BaseNavigator {

    val transitionIn = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    val transitionOut = navOptions {
        anim {
            enter = R.anim.slide_in_left
            exit = R.anim.slide_out_right
            popEnter = R.anim.slide_in_right
            popExit = R.anim.slide_out_left
        }
    }
}