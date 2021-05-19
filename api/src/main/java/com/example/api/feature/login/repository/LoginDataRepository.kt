package com.example.api.feature.login.repository

import com.example.api.feature.login.LoginRepository
import com.example.entity.login.domain.Login
import com.example.entity.login.payload.ExampleResponse
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LoginDataRepository @Inject constructor(
    private val loginApi: com.example.api.feature.login.api.LoginApi,
    private val sharedPrefs: com.example.core_storage.sharedpref.SharedPrefs,
    private val loginDao: com.example.core_storage.dao.LoginDao
): LoginRepository {

    override fun getUserInfo(): Single<ExampleResponse> {
        return loginApi.getUserInfo().doOnSuccess {
            loginDao.insert(
                Login(
                    2,
                    "Junifer2"
                )
            )
        }
    }

    override fun getUserIdPref(): Single<String> {
        return Single.just(sharedPrefs.userId)
    }

    override fun saveDataToDb(login: Login): Completable {
        return Completable.fromCallable {
            loginDao.insertAndDeleteAll(login)
        }
    }

    override fun getDataFromDb(): Single<Login> {
        return loginDao.getFirst().toSingle()
    }
}