package com.example.core

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core_entity.login.Login
import com.example.core_entity.login.LoginDao

@Database(
        entities = [
            Login::class
        ],
        version = BuildConfig.DATABASE_VERSION
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
}
