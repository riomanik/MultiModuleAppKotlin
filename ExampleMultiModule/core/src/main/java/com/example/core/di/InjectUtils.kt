package com.example.core.di

import android.content.Context

object InjectUtils {

    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement CoreComponentProvider")
        }
    }
}