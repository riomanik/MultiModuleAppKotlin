package com.example.loginfeature.module

import com.example.core.RoomDatabase
import com.example.core.common.SharedPrefs
import com.example.core_entity.login.LoginDao
import com.example.loginfeature.data.LoginApi
import com.example.loginfeature.data.LoginDataRepository
import com.example.loginfeature.domain.LoginRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class LoginModule {

    @Provides
    fun provideApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Provides
    fun provideDatabaseLogin(
        roomDatabase: RoomDatabase
    ): LoginDao {
        return roomDatabase.loginDao()
    }

    @Provides
    fun provideRepository(
        loginApi: LoginApi,
        sharedPrefs: SharedPrefs,
        loginDao: LoginDao
    ): LoginRepository {
        return LoginDataRepository(loginApi, sharedPrefs, loginDao)
    }

}