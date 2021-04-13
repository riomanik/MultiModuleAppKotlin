package com.example.loginfeature.data

import android.util.Log
import com.example.core.common.SharedPrefs
import com.example.loginfeature.domain.Login
import com.example.loginfeature.domain.LoginRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LoginDataRepository @Inject constructor(
    private val loginApi: LoginApi,
    private val sharedPrefs: SharedPrefs,
    private val loginDao: LoginDao
): LoginRepository {

    override fun getUserInfo(): Single<ExampleResponse> {
        return loginApi.getUserInfo()
    }

    override fun getUserIdPref(): Single<String> {
        return Single.just(sharedPrefs.userId)
    }

    override fun saveDataToDb(login: Login): Completable {
        Log.i("USERNAMENNYA", login.username)
        return Completable.fromCallable {
            loginDao.insertAndDeleteAll(login)
        }
    }

    override fun getDataFromDb(): Single<List<Login>> {
        return loginDao.getItems()
    }
}