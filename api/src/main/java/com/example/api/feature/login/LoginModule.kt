package com.example.api.feature.login

import com.example.api.feature.login.api.LoginApi
import com.example.api.feature.login.repository.LoginDataRepository
import com.example.core_storage.dao.LoginDao
import com.example.core_storage.module.CoreStorageModule
import com.example.core_storage.sharedpref.SharedPrefs
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [CoreStorageModule::class])
class LoginModule {

    @Singleton
    @Provides
    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

    @Provides
    fun provideRepository(
        loginApi: LoginApi,
        sharedPrefs: SharedPrefs,
        loginDao: LoginDao
    ): LoginRepository {
        return LoginDataRepository(loginApi, sharedPrefs, loginDao)
    }


}