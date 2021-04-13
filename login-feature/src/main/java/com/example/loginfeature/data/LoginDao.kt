package com.example.loginfeature.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.core.base.BaseDao
import com.example.loginfeature.domain.Login
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface LoginDao : BaseDao<Login> {

    @Query("SELECT * FROM ${Login.TABLE_NAME} WHERE ${Login.COLUMN_USER_ID} = :id")
    override fun getItem(id: Long): Single<Login>

    @Query("SELECT * FROM ${Login.TABLE_NAME} LIMIT 1")
    fun getFirst(): Maybe<Login>

    @Query("SELECT * FROM ${Login.TABLE_NAME} ORDER BY ${Login.COLUMN_USER_ID} ASC")
    override fun getItems(): Single<List<Login>>

    @Query("DELETE FROM ${Login.TABLE_NAME}")
    override fun deleteAll()

    @Transaction
    fun insertAndDeleteAll(user: Login) {
        deleteAll()
        insert(user)
    }
}
