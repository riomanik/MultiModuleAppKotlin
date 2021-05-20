package com.example.api.feature.login

import com.example.api.feature.login.api.LoginApi
import com.example.api.feature.login.repository.LoginDataApiRepository
import com.example.core_storage.dao.LoginDao
import com.example.core_storage.module.CoreStorageModule
import com.example.core_storage.sharedpref.SharedPrefs
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CoreStorageModule::class])
class LoginApiModule {

    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

    @Provides
    fun provideRepository(
        loginApi: LoginApi,
        sharedPrefs: SharedPrefs,
        loginDao: LoginDao
    ): LoginApiRepository {
        return LoginDataApiRepository(loginApi, sharedPrefs, loginDao)
    }


}