package com.example.loginfeature.module

import android.content.Context
import android.util.Log
import com.example.core.common.SharedPrefs
import com.example.loginfeature.data.DatabaseLogin
import com.example.loginfeature.data.LoginApi
import com.example.loginfeature.data.LoginDao
import com.example.loginfeature.data.LoginDataRepository
import com.example.loginfeature.domain.LoginRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named

@Module
class LoginModule {

    @Provides
    fun provideApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Provides
    fun provideDatabaseLogin(
        context: Context,
        @Named("APP_DATABASE_NAME") databaseName: String,
        @Named("BASE_API_URL") baseUrl: String
    ): DatabaseLogin {
        Log.i("databasenyaapa", databaseName)
        Log.i("apiUrlnyaapa", baseUrl)
        return DatabaseLogin.getInstance(context, databaseName)
    }

    @Provides
    fun provideLoginDao(database: DatabaseLogin): LoginDao {
        return database.loginDao()
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