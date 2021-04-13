package com.example.core.di

import android.app.Application
import android.content.Context
import com.example.core.RoomDatabase
import com.example.core.common.SharedPrefs
import com.example.core.module.CoreModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    fun inject(app: Application)

    fun getContext(): Context

    fun getApplication(): Application

    @Named("BASE_API_URL")
    fun getBaseApiUrl(): String

    fun getNetworkService(): Retrofit

    fun getDatabaseService(): RoomDatabase

    fun getSharedPref(): SharedPrefs

}