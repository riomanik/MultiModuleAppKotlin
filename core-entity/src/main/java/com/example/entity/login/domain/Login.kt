package com.example.entity.login.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.entity.login.domain.Login.Companion.TABLE_NAME
import kotlinx.android.parcel.Parcelize

@Entity(tableName = TABLE_NAME)
@Parcelize
data class Login(
    @PrimaryKey val userId: Long,
    val username: String
) : Parcelable {

    companion object {
        const val TABLE_NAME = "Login"
        const val COLUMN_USER_ID = "userId"
        const val COLUMN_USERNAME = "username"
    }

}

