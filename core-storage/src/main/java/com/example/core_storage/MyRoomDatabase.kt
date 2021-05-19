package com.example.core_storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.core_storage.dao.LoginDao
import com.example.entity.BuildConfig
import com.example.entity.login.domain.Login

@Database(
    entities = [
        Login::class
    ],
    version = BuildConfig.DATABASE_VERSION
)
abstract class MyRoomDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao

    companion object {

        @Volatile
        private var instance: MyRoomDatabase? = null

        fun getInstance(context: Context): MyRoomDatabase = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): MyRoomDatabase =
            Room.databaseBuilder(context, MyRoomDatabase::class.java, BuildConfig.DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
