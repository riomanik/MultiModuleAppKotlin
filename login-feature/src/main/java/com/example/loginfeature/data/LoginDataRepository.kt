package com.example.loginfeature.data

import com.example.core.common.SharedPrefs
import com.example.core_entity.login.Login
import com.example.core_entity.login.LoginDao
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
        return loginApi.getUserInfo().doOnSuccess {
            loginDao.insert(Login(2, "Junifer2"))
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