package com.example.splashscreen_feature.module

import com.example.core.RoomDatabase
import com.example.core_entity.login.LoginDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class SplashScreenModule {

    @Provides
    fun provideDatabaseLogin(
        roomDatabase: RoomDatabase
    ): LoginDao {
        return roomDatabase.loginDao()
    }


}